# Android Process Manager
A demonstartion on how OS-level process management is done in Android. Typically, process management is a job which should be left to the 
OS because the user can corrupt some memory management. However, this is just a demonstartion on how one might go about
managing the running process on their android device if they had to. 

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
You need to make sure that you are using an Android API version that is lower than 5.1.1. This is because Google has made it 
signinficantly harder for one to view the runnning process on the Android device. One of the most important APIs
used in this appliation is ```getRunningAppProcessInfo()```. 
The two other important APIs that deal with the actual killing of the processes are: 
```
Process.killProcess(pid) or Process.sendSignal(pid, PROCESS.SIGNAL_KILL)
ActivityManager.killBackgroundProcesses(PackageName)
```
A full report on the application can be found below:
* [Project Proposal](https://drive.google.com/file/d/1JoafqpxZwuYotIc1tgREnLs90rGOLAFq/view?usp=sharing)
* [Project Report](https://drive.google.com/file/d/1-HS-UUOJPVPL_cNWUU33mSpoZy0CP7kh/view?usp=sharing)

## Deployment
Make sure you have an Android API lower than 5.1.1 on Android Studio or an actual Android phone. From there you can just clone this repository
through Android Studio.

## Acknowledgements
* [itcuties](http://www.itcuties.com/android/how-to-get-running-process-list-and-traffic-statistics/)
