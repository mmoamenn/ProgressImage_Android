# ProgressImage Android

Progress Image is a Library for modern progress view style put 
you image/icon as a progress view for you 

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
	        compile 'com.github.mmoamenn:ProgressImage_Android:0.0.1'
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