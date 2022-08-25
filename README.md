# ShadowIndicatorBottomNavigationView-library
A lightweight Android material bottom navigation bar with shadow indicator library

[![](https://jitpack.io/v/TrooNikhilFlutter/ShadowIndicatorBottomNav-library.svg)](https://jitpack.io/#TrooNikhilFlutter/ShadowIndicatorBottomNav-library)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)

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

<img src="https://user-images.githubusercontent.com/86345401/186606844-d23dd1db-2901-4997-b29b-917421a59a67.gif" width="300" />

## Customization

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
    app:menu="@menu/bottom_navigation"

    app:indicatorHeaderHeight="8dp"
    app:indicatorHeaderColor="@color/purple_700"
    app:indicatorShadowColor="@color/purple_200"
    app:indicatorShadowVisible="true"
    />
```
<img width="300" alt="Customization" src="https://user-images.githubusercontent.com/86345401/186608887-320294bf-d675-4763-87eb-eb9df6098482.png">

| Syntax                        | Description                               |
| ----------------------------- | -----------                               |
| app:indicatorHeaderHeight     | Height of top rounded rect                |
| app:indicatorHeaderColor      | Color of top rounded rect                 |
| app:indicatorShadowColor      | Color of shadow                           |
| app:indicatorShadowVisible    | Shadow is visible or not, Default is true |

## Setup

```gradle
//project label build.gradle
buildscript {
    repositories {
         ....
        maven { url 'https://jitpack.io' }
    }
}

allprojects {
    repositories {
     .......
        maven { url 'https://www.jitpack.io' }
    }
}
//app label build.gradle
dependencies {
    implementation 'com.github.TrooNikhilFlutter:ShadowIndicatorBottomNav-library:1.0.0'
}
```
