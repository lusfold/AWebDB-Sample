# AWebDB

***

[![build passing](https://img.shields.io/badge/build-passing-green.svg?style=flat)](https://bintray.com/lusfold/maven/AWebDB/view)
[![AWebDB Maven](https://img.shields.io/badge/AWebDB-Maven-green.svg?style=flat)](https://bintray.com/lusfold/maven/AWebDB/view)  

I found it was pretty hard to check database when you develop apps, cause you had to export th db file then...

Finally,i found nanohttpd, a android base mini web server.

As you see,i made AWebDB (Android web database),help you to look up you sqlite databse from web browser.


#Quickstart

####step 1

add dependency

```gradle
dependencies {
compile 'com.lusfold.awebdb:awebdb:0.1.0'
}
```

####step 2

hook it

```java
AWebDB.hook(mContext, dbName,port)  
String ip=AWebDB.getLocalIPAddress();  
int port = AWebDB.getLocalServerPort();  
```

####step 3

in your browser  
http://ip:port/?sql  

like this:

http://192.168.1.141:8080/?SELECT * FROM sqlite_master WHERE type = 'table';

***

#LICENSE

Copyright 2014-2015 AigeStudio(https://github.com/AigeStudio)

Licensed under the Apache License, Version 2.0 (the "License");you may not use this file except in compliance with the License.

You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.