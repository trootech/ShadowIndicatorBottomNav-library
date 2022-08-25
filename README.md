# ShadowIndicatorBottomNavigationView-library
A lightweight Android material bottom navigation bar with shadow indicator library

[![](https://jitpack.io/v/TrooNikhilFlutter/ShadowIndicatorBottomNav-library.svg)](https://jitpack.io/#TrooNikhilFlutter/ShadowIndicatorBottomNav-library)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)

[comment]: <> ([![Android Arsenal]&#40; https://img.shields.io/badge/Android%20Arsenal-SmoothBottomBar-green.svg?style=flat &#41;]&#40; https://android-arsenal.com/details/1/7932 &#41;)

[comment]: <> ([![Android Weekly]&#40;https://androidweekly.net/issues/issue-385/badge&#41;]&#40;https://androidweekly.net/issues/issue-385&#41;)

[comment]: <> (## GIF)

[comment]: <> (<img src="https://cdn.dribbble.com/users/1015191/screenshots/6251784/snapp---animation.gif"/>)

[comment]: <> (## Design Credits)

[comment]: <> (All design and inspiration credits belong to [Alejandro Ausejo]&#40;https://dribbble.com/shots/6251784-Navigation-Menu-Animation&#41;.)

## Usage

-   Create menu.xml under your res/menu/ folder
```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <item
        android:id="@+id/item1"
        android:enabled="true"
        android:icon="@drawable/home"
        android:title="@string/home"
        app:showAsAction="ifRoom" />

    <item
        android:id="@+id/item2"
        android:enabled="true"
        android:icon="@drawable/phone"
        android:title="@string/phone"
        app:showAsAction="ifRoom" />

    <item
        android:id="@+id/item3"
        android:enabled="true"
        android:icon="@drawable/settings"
        android:title="@string/settings"
        app:showAsAction="ifRoom" />

    <item
        android:id="@+id/item4"
        android:enabled="true"
        android:icon="@drawable/star"
        android:title="@string/star"
        app:showAsAction="ifRoom" />

    <item
        android:id="@+id/item5"
        android:enabled="true"
        android:icon="@drawable/user"
        android:title="@string/user"
        app:showAsAction="ifRoom" />

</menu>
```

-   Add view into your layout file
```xml
<com.shadowindicatorbottomnavigationview.ShadowIndicatorBottomNavigationView
    android:id="@+id/bottom_navigation_view"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="24dp"
    android:background="@drawable/black_rounded"
    android:clipToOutline="true"
    android:elevation="8dp"
    android:minHeight="70dp"
    app:itemIconTint="@drawable/bottom_navigation_view_item_tint"
    app:itemTextColor="@drawable/bottom_navigation_view_item_tint"
    app:labelVisibilityMode="unlabeled"
    app:elevation="20dp"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:menu="@menu/bottom_navigation" />
```


### Result Demo:

<p align="center"><a>
  <video src="https://user-images.githubusercontent.com/86345401/186605024-1f180dd0-3d59-4afa-b3c4-d94587b1d5e4.mov" type="video/mp4"></a></p>





[comment]: <> (## Customization)

[comment]: <> (```xml)

[comment]: <> (<me.ibrahimsn.lib.SmoothBottomBar)

[comment]: <> (        android:id="@+id/bottomBar")

[comment]: <> (        android:layout_width="match_parent")

[comment]: <> (        android:layout_height="70dp")

[comment]: <> (        app:menu="")

[comment]: <> (        app:backgroundColor="")

[comment]: <> (        app:indicatorColor="")

[comment]: <> (        app:indicatorRadius="")

[comment]: <> (        app:cornerRadius="")

[comment]: <> (        app:corners="")

[comment]: <> (        app:sideMargins="")

[comment]: <> (        app:itemPadding="")

[comment]: <> (        app:textColor="")

[comment]: <> (        app:itemFontFamily="")

[comment]: <> (        app:textSize="")

[comment]: <> (        app:iconSize="")

[comment]: <> (        app:iconTint="")

[comment]: <> (        app:iconTintActive="")

[comment]: <> (        app:activeItem="")

[comment]: <> (        app:duration="" />)

[comment]: <> (```)

[comment]: <> (## Setup)

[comment]: <> (> Follow me on Twitter [@ibrahimsn98]&#40;https://twitter.com/ibrahimsn98&#41;)

[comment]: <> (```gradle)

[comment]: <> (//project label build.gradle)

[comment]: <> (buildscript {)

[comment]: <> (    repositories {)

[comment]: <> (         ....)

[comment]: <> (        maven { url 'https://jitpack.io' })

[comment]: <> (    })

[comment]: <> (})

[comment]: <> (allprojects {)

[comment]: <> (    repositories {)

[comment]: <> (     .......)

[comment]: <> (        maven { url 'https://www.jitpack.io' })

[comment]: <> (    })

[comment]: <> (})

[comment]: <> (//app label build.gradle)

[comment]: <> (dependencies {)

[comment]: <> (        implementation 'com.github.ibrahimsn98:SmoothBottomBar:1.7.9')

[comment]: <> (})

[comment]: <> (```)

[comment]: <> (## Contributors ✨)

[comment]: <> (<table>)

[comment]: <> (    <tr>)

[comment]: <> (        <td align="center">)

[comment]: <> (            <a href="https://github.com/brookmg">)

[comment]: <> (                <img src="https://avatars3.githubusercontent.com/u/7487888?s=460&u=7ba52b250536b301987aaa350f605bbaf3ffa8ed&v=4" width="100px;" alt=""/><br />)

[comment]: <> (                <sub><b>brookmg</b></sub>)

[comment]: <> (            </a>)

[comment]: <> (        </td>)

[comment]: <> (        <td align="center">)

[comment]: <> (            <a href="https://github.com/rezaepsilon0">)

[comment]: <> (                <img src="https://avatars0.githubusercontent.com/u/18679475?s=460&u=a5e771cc32bff987aceccafa55edab06a8aa804f&v=4" width="100px;" alt=""/><br />)

[comment]: <> (                <sub><b>rezaepsilon0</b></sub>)

[comment]: <> (            </a>)

[comment]: <> (        </td>)

[comment]: <> (        <td align="center">)

[comment]: <> (            <a href="https://github.com/amitdash291">)

[comment]: <> (                <img src="https://avatars2.githubusercontent.com/u/18529185?s=460&v=4" width="100px;" alt=""/><br />)

[comment]: <> (                <sub><b>amitdash291</b></sub>)

[comment]: <> (            </a>)

[comment]: <> (        </td>)

[comment]: <> (           <td align="center">)

[comment]: <> (            <a href="https://github.com/tobiasschuerg">)

[comment]: <> (                <img src="https://avatars2.githubusercontent.com/u/1324555?s=460&v=4" width="100px;" alt=""/><br />)

[comment]: <> (                <sub><b>tobiasschuerg</b></sub>)

[comment]: <> (            </a>)

[comment]: <> (        </td>)

[comment]: <> (        </td>)

[comment]: <> (           <td align="center">)

[comment]: <> (            <a href="https://github.com/mayokunthefirst">)

[comment]: <> (                <img src="https://avatars0.githubusercontent.com/u/29807085?s=460&u=493fd9b143dd96eecea56749f57d20e002e246e4&v=4" width="100px;" alt=""/><br />)

[comment]: <> (                <sub><b>mayokunthefirst</b></sub>)

[comment]: <> (            </a>)

[comment]: <> (        </td>)

[comment]: <> (        <td align="center">)

[comment]: <> (            <a href="https://github.com/FannyDemey">)

[comment]: <> (                <img src="https://avatars.githubusercontent.com/u/3006608?v=4" width="100px;" alt=""/><br />)

[comment]: <> (                <sub><b>FannyDemey</b></sub>)

[comment]: <> (            </a>)

[comment]: <> (        </td>)

[comment]: <> (    </tr>)

[comment]: <> (    <tr>)

[comment]: <> (    	 <td align="center">)

[comment]: <> (            <a href="https://github.com/Milad-Akarie">)

[comment]: <> (                <img src="https://avatars.githubusercontent.com/u/55059449?v=4" width="100px;" alt=""/><br />)

[comment]: <> (                <sub><b>Milad akarie</b></sub>)

[comment]: <> (            </a>)

[comment]: <> (        </td>)

[comment]: <> (    </tr>)

[comment]: <> (</table>)


[comment]: <> (## License)

[comment]: <> (```)

[comment]: <> (MIT License)

[comment]: <> (Copyright &#40;c&#41; 2019 İbrahim Süren)

[comment]: <> (Permission is hereby granted, free of charge, to any person obtaining a copy)

[comment]: <> (of this software and associated documentation files &#40;the "Software"&#41;, to deal)

[comment]: <> (in the Software without restriction, including without limitation the rights)

[comment]: <> (to use, copy, modify, merge, publish, distribute, sublicense, and/or sell)

[comment]: <> (copies of the Software, and to permit persons to whom the Software is)

[comment]: <> (furnished to do so, subject to the following conditions:)

[comment]: <> (The above copyright notice and this permission notice shall be included in all)

[comment]: <> (copies or substantial portions of the Software.)

[comment]: <> (THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR)

[comment]: <> (IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,)

[comment]: <> (FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE)

[comment]: <> (AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER)

[comment]: <> (LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,)

[comment]: <> (OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE)

[comment]: <> (SOFTWARE.)

[comment]: <> (```)
