# AutoScreenModule
<br/>
<br/>



## 1. AutoScreenView

> 이것은 화면을 해상도에 맞게 자동으로 설정해주는 Object 클래스입니다.<br/>
> This is an Object Class that automatically sets the screen to the resolution.


### Kotlin Function

```kotlin
/**
 * - Activity 의 밀도를 자동으로 설정한다.
 * - The density of the Activity is automatically set.
 *
 * @param activity -> Activity
 *
 * @param hasStatusBar -> Status bar Status
 */
fun setActivityView(activity: Activity, hasStatusBar: Boolean)

/**
 * - Fragment 의 밀도를 자동으로 설정한다.
 * - The density of the Fragment is automatically set.
 *
 * @param activity -> Activity
 *
 * @param view -> View of Fragment
 *
 * @param hasStatusBar -> Status bar Status
 */
fun setFragmentView(activity: Activity, view: View?, hasStatusBar: Boolean)

/**
 * - ItemView 의 밀도를 자동으로 설정한다.
 * - The density of the ItemView is automatically set.
 *
 * @param view -> Item View
 */
fun setItemView(view: View?)
```
<br/>
<br/>


