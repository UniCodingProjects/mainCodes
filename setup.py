from setuptools import setup

requirementsFile = open("requirements", "r")
requirements = requirementsFile.read().split('\n')

setup(name='SETUP',
      version='0.2',
      description='Python packages setup',
      url='https://github.com/OpenUniCodingProjects/mainCodes',
      author='Roman R',
      install_requires=requirements,
      zip_safe=False)



