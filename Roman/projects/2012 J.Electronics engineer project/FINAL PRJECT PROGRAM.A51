org 0
ljmp main
org 3
ljmp keyb
org 13h
ljmp rfid
clcd equ 2000h
dlcd equ 2001h
adkeyb equ 4000h
pcount equ 40h
tcount equ 45h
ppcount equ 60h
ttcount equ 65h
newcodecount equ 55h
org 100h
delay300:	mov r7,#4h
		dl33:mov r6,#0ffh
		dl32:mov r5,#0ffh
		dl31:djnz r5,dl31
		djnz r6,dl32
		djnz r7,dl33
ret
;------------------------------
ldelay:		mov r7,#60
		dl333:mov r6,#0ffh
		dl322:mov r5,#0ffh
		dl311:djnz r5,dl311
		djnz r6,dl322
		djnz r7,dl333
ret
;------------------------------
delay:	mov r6,#80h
	d1:mov r5,#0ffh
	djnz r5,$
	djnz r6,d1
ret
;---------------------------
initlcd:lcall delay300              ;delay configuration
	mov dptr,#clcd
	mov a,#38h
	movx @dptr ,a
	lcall delay
	mov a,#0eh 
	movx @dptr ,a
	lcall delay
	mov a,#01h
	movx @dptr,a
	lcall delay
	ret
;----------------------------------------------------
comlcd:push dph
push dpl
mov dptr,#clcd
movx @dptr,a
lcall delay
pop dpl
pop dph
ret
;------------------------------
displcd:push dph
push dpl
mov dptr,#dlcd
movx @dptr,a
lcall delay  
pop dpl
pop dph
ret
;------------------------------
rfid:	clr ea
	push dph
	push dpl
	setb 25h
	jnb 26h,out1
	mov a,#01h
	lcall comlcd
	mov dptr,#msg7                      ;door open
	lcall dispmsg
	mov a,#0c0h             ;LCD new line
	lcall comlcd
	mov dptr,#msg21
	lcall dispmsg
	clr p1.1
	lcall ldelay
	jmp fullreset
	
	
out1:	mov a,#01h
	lcall comlcd
	mov dptr,#msg2
 	lcall dispmsg
 	mov a,#0c0h             ;LCD new line
	lcall comlcd
	mov dptr,#msg3
	lcall dispmsg                      
out2:	pop dpl
	pop dph
	setb ea
	reti

	
keyb:	clr ea                            ;keyboard config
	push dph
	push dpl  
;----------------------------
	mov dptr,#adkeyb
	movx a,@dptr
	anl a,#0fh
	mov dptr,#table               ;keyboard keys matching config
        movc a,@a+dptr
        jb 29h, acheckx
        jb 28h, newcodex
        jb 23h, beinaim 		;jump to alarm deactivation subroutin
	mov 46h,a
	mov a,#2ah 			;(*) config
	lcall displcd
	mov a,46h
;------------------------------
codecheck:
press1:
	mov r0,pcount;4
	cjne r0,#4, press2
	dec pcount
	cjne a,70h, mistakex
	jmp sof
press2:
	mov r0,pcount;3
	cjne r0,#3, press3
	dec pcount
	cjne a,71h, mistakex
	jmp sof
press3:
	mov r0,pcount;2
	cjne r0,#2, press4
	dec pcount;1
	cjne a,72h, mistakex
	jmp sof
press4:
	dec pcount;0
	cjne a,73h, mistakex
	jnb 22h, success
	jmp mistake
alarm:	
        mov a,#01h 		;LCD clear
	lcall comlcd
	mov dptr,#msg4
 	lcall dispmsg
 	mov a,#0c0h             ;LCD new line
	lcall comlcd
	mov dptr,#msg18
	lcall dispmsg  
	setb p1.0
	setb 23h
	jmp sof
mistakex:
jmp mistake

beinaim:
jmp codecheck2

sofy:
jmp sofz

newcodex:
jmp newcode

;sofrfidy:
;jmp sofrfidx

;fullresetx:
;jmp fullreset

acheckx:
jmp acheck

reset1:
        mov a,#01h 		;LCD clear
	lcall comlcd
	mov dptr,#msg5
	lcall dispmsg
	lcall delay300
	lcall delay300
	mov a,#01h             ;LCD clear
	lcall comlcd
	mov dptr,#msg2
 	lcall dispmsg
 	mov a,#0c0h             ;LCD new line
	lcall comlcd
	mov dptr,#msg3
	lcall dispmsg               
	clr 22h
	dec tcount
	mov pcount,#4
	jmp sof
	
mistake:
	setb 22h
	mov r0,pcount
	cjne r0,#0,sofa
	mov r1,tcount
	cjne r1,#0h,reset1
	jmp alarm
	
;sofrfidx:
;jmp sofrfid
	


success:
	setb 29h
	setb 26h
	mov a,#01h        ;LCD Clear
	lcall comlcd
	mov dptr,#msg8                   ;press A to open door
	lcall dispmsg
	mov a,#0c0h
	lcall comlcd
	mov dptr,#msg11
	lcall dispmsg
	lcall delay300
	lcall delay300
	mov a,#01h        ;LCD Clear
	lcall comlcd
	mov dptr,#msg9           	;press B to change code
	lcall dispmsg 
	mov a,#0c0h
	lcall comlcd
	mov dptr,#msg12
	lcall dispmsg
	lcall delay300
	lcall delay300
	mov a,#01h        ;LCD Clear
	lcall comlcd
	jmp sof
sofa:
jmp sofz
	
acheck:
	cjne a,#0ah,bcheck
	clr 29h
	jb 25h,open
	mov dptr,#msg6
	lcall dispmsg
        jmp rfidcheck
        jmp sof
        
bcheck:
 	cjne a,#0bh,sofz
 	clr 29h
 	setb 28h
 	mov dptr,#msg10              ;enter new code
	lcall dispmsg
	mov a,#0c0h        ;LCD next line
	lcall comlcd
	mov dptr,#msg3
	lcall dispmsg
	jmp sof
 	               
rfidcheck:
	jnb 25h,sofz                       ;check for rfid key
open:	mov dptr,#msg7                      ;door open
	lcall dispmsg
	mov a,#0c0h             ;LCD new line
	lcall comlcd
	mov dptr,#msg21
	lcall dispmsg
	clr p1.1
	lcall ldelay
	jmp fullreset
	
	
sofrfid:
	mov a,#01h        ;LCD Clear
	lcall comlcd
	mov dptr,#msg6
	lcall dispmsg
	jmp sofz
sofz:
jmp sofx

		
newcode: 
	mov 46h,a
	mov a,#2ah 			;(*) config
	lcall displcd
	mov a,46h
press111:
	mov r0,newcodecount
	cjne r0,#4, press222
	dec newcodecount
	mov 70h,a
	jmp sof
press222:
	mov r0,newcodecount
	cjne r0,#3, press333
	dec newcodecount
	mov 71h,a
	jmp sof
press333:
	mov r0,newcodecount
	cjne r0,#2, press444
	dec newcodecount
	mov 72h,a
	jmp sof
press444:
	dec pcount
	mov 73h,a
	clr 28h
	clr 29h
	jmp fullreset
;-----------------------------------------------	
codecheck2:              
	mov 46h,a
	mov a,#2ah 			;(*) config
	lcall displcd
	mov a,46h  
	                   ;alarm de activation codecheck
press11:
	mov r0,ppcount;4
	cjne r0,#4, press22
	dec ppcount
	cjne a,#9, mistake2
	jmp sof
press22:
	mov r0,ppcount;3
	cjne r0,#3, press33
	dec ppcount
	cjne a,#8, mistake2
	jmp sof
press33:
	mov r0,ppcount;2
	cjne r0,#2, press44
	dec ppcount;1
	cjne a,#7, mistake2
	jmp sof
press44:
	dec ppcount;0
	cjne a,#6, mistake2
	jnb 24h, alarmmsg
	jmp sof		
	
mistake2:
	setb 24h
	mov r0,ppcount
	cjne r0,#0,sofx
	mov r1,ttcount
	cjne r1,#0h,reset2
sofx:
jmp sof

alarmmsg:
	mov a,#01h
	lcall comlcd
	mov dptr,#msg19
	lcall dispmsg
	mov a,#0c0h             ;LCD new line
	lcall comlcd
	mov dptr,#msg20
	lcall dispmsg
	lcall delay300
	lcall delay
	jmp fullreset

reset2:
	clr 24h
	dec ttcount
	mov ppcount,#4
	jmp sof
	
fullreset:           ;alarm deactivation sequence
	clr 22h
	clr 23h
	clr 24h
	clr 25h
	clr 26h
	clr 28h
	clr 29h
	clr p1.0
	setb P1.1
	mov pcount,#4 ;presscounter
	mov tcount,#2 ;try counter
	mov ppcount,#4 ;alarm deactivate press counter
	mov ttcount,#100 ;alarm deactivate try counter
	mov newcodecount,#4 ;press count for new code
	mov a,#01h
	lcall comlcd
	mov dptr,#msg1
	lcall dispmsg
	mov a,#0c0h             ;LCD new line
	lcall comlcd
	lcall delay300
	lcall delay300
	mov a,#01h		;LCD clear
	lcall comlcd
	mov dptr,#msg15
	lcall dispmsg
	mov a,#0c0h             ;LCD new line
	lcall comlcd
	mov dptr,#msg3
	lcall dispmsg
	mov dptr,#msg16
	lcall dispmsg
	lcall delay300
	lcall delay300	
	mov a,#01h		;LCD clear
	lcall comlcd
	mov dptr,#msg2
 	lcall dispmsg
 	mov a,#0c0h             ;LCD new line
	lcall comlcd
	mov dptr,#msg3
	lcall dispmsg       
	
sof:
	pop dpl 
	pop dph
	jnb p3.2,$
	setb ea
	reti
;-------------------------   
msg1:DB '  Welcome  To',0ffh
msg2:DB '   Enter Code',0ffh
msg3:DB '    ',0ffh
msg4:DB '   -=Alarm=-',0ffh
msg5:DB '   Try Again',0ffh
msg6:DB 'Pass RFID key',0ffh
msg7:DB 'Please Enter ',0ffh
msg8:DB 'To Open Door',0ffh
msg9:DB 'TO Change Code',0ffh
msg10:DB 'Enter NEW code',0ffh
msg11:DB 'Press A ',0ffh
msg12:DB 'Press B',0ffh
msg13:DB 'Enter Code',0ffh
msg14:DB '  ',0ffh
msg15:DB 'Roman Rapoports',0ffh
msg16:DB 'Project',0ffh
;msg17:DB '',0ffh
msg18:DB '     ',0ffh
msg19:DB '    Alarm',0ffh
msg20:DB ' Deactivated',0ffh
msg21:DB '    house',0ffh
table: DB 1,2,3,0ah,4,5,6,0bh,7,8,9,0ch,0,23h,0dh   ;keyboard keys config
;----------------------
	dispmsg:clr a
	movc a,@a+dptr
	cjne a,#0ffh,nextch
	ret
	nextch:lcall displcd
	inc dptr
	jmp dispmsg
	
main:	clr ea
	lcall initlcd   
	clr p1.0 				   ;alarm off 
	setb p1.1                                 ;lock locked       
	mov dptr,#msg1                                    ;;;Messages at begginign starts here !!!!!!!
	lcall dispmsg 
	lcall delay300
	lcall delay300
	mov a,#01h		;LCD clear
	lcall comlcd
	mov dptr,#msg15
	lcall dispmsg
	mov a,#0c0h             ;LCD new line
	lcall comlcd
	mov dptr,#msg3
	lcall dispmsg
	mov dptr,#msg16
	lcall dispmsg
	lcall delay300
	lcall delay300	
	mov a,#01h		;LCD clear
	lcall comlcd                             ;;;Messages at begginign Ends here !!!!!!!
;--------------------------
;hagdaratcod:
	mov 70h,#1             ;password config (Defualt password - can be changed in future)
	mov 71h,#2
	mov 72h,#3
	mov 73h,#4 
	;---------
	mov 47h,#9		;alarm deactivate password config
	mov 48h,#8
	mov 49h,#7
	mov 50h,#6
	;---------   start of clears
	clr 22h
	clr 23h
	clr 24h
	clr 25h
	clr 26h
	clr 28h
	clr 29h

;'enter code'                            ;;;;Msges that stays for code inputs starts
 	mov dptr,#msg2
 	lcall dispmsg
 	;mov a,#01h 
 	mov a,#0c0h             ;LCD new line
	lcall comlcd
	mov dptr,#msg3
	lcall dispmsg                          ;;;;Msges that stays for code inputs ends
;sof 'enter code'
	mov pcount,#4 ;presscounter
	mov tcount,#2 ;try counter
	mov ppcount,#4 ;alarm deactivate press counter
	mov ttcount,#100 ;alarm deactivate try counter
	mov newcodecount,#4 ;press count for new code
	mov ie,#85h
	jmp $
END 