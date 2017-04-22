# ProgressImage Android

ProgressImage is a Library for modern progress view style. Use any icon/image with progress view for your application

**Samples :**

![Progress Image](https://github.com/mmoamenn/ProgressImage_Android/blob/master/sample/videotogif_2017.04.18_22.09.44.gif)

![Progress Image](https://github.com/mmoamenn/ProgressImage_Android/blob/master/sample/videotogif_2017.04.18_22.08.12.gif)


**Installation**

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
Step 2. Add the dependency

	dependencies {
	        compile 'com.github.mmoamenn:ProgressImage_Android:0.0.2'
	}


**XML**

    <com.bluehomestudio.progressimage.ProgressPicture
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/ic_action_name"
        ProgressPicture:animation="fade" />
        
You must use the following properties in your XML to change progress animation 

`ProgressPicture:animation` 
* fade -> default
* scale
* rotate
* rotate_x
* rotate_y

**JAVA**

Functions to use after reference the ProgressPicture

* `startAnimation();`
* `stopAnimation();`
* `stopAnimationAndHide();`
