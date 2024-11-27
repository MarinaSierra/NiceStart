# PROYECTO DE COMIENZO: NICESTART
(Añadí una Lottie en el activity LOGIN)Anahi Hinojosa
We have six activities/interactions until now: **SPLASH**, **LOGIN**,  **SIGN UP**, **MAIN**, **PROFILE** and **EDIT PROFILE**. 

## SPLASH: 
Firstly, when opening the app, it shows the splash activity, 
which then will be automatically redirect to Login.

![splash_activity](img/splash.png)

## LOGIN: 
![login activity](img/login.png)

## SIGN UP: 
![signup_activity](img/sign_up.png)

Both activities are **related**: 

### In login activity: 
    android:onClick="openSignUp"
### Important code to know: 
    public void openSignUp(View view) {
        Intent intent1 = new Intent(Login.this, SignUp.class);
        startActivity(intent1);
    }

## Main: 
In this activity, I am testing some functions as the SnackBar:

    `Snackbar snackbar1 = Snackbar.make(mLayout, "Action is done", Snackbar.LENGTH_SHORT);
    snackbar1.show();`
Toast function, which pops up with some information:

    `Toast.makeText(this, "Item copied", Toast.LENGTH_SHORT).show();`


It now has a WebView which refresh an image of a web: 

    `miVisorWeb = (WebView) findViewById(R.id.vistaweb);
    WebSettings webSettings = miVisorWeb.getSettings();
    webSettings.setLoadWithOverviewMode(true);
    webSettings.setUseWideViewPort(true);
    miVisorWeb.loadUrl("https://thispersondoesnotexist.com");`


Another new function, is the Swipe Refresh Layout: 

    `protected SwipeRefreshLayout.OnRefreshListener
        mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                miVisorWeb.reload();
                swipeLayout.setRefreshing(false);
        }
    };`


It looks like this:

![main_activity](img/main.png)

You can go to your profile by clicking the person icon: 
![profile_icon](img/person_icon.png)

## Profile: 
![profile_activity](img/profile.png)

This activity adds the name you've introduced by editing the profile. 
It includes an edit button which sends you to this: 

## Edit profile: 
![edit_profile_activity](img/edit_profile.png)


Each activity has a glide, which can access to an image from the internet, your local file, etc... 
It has some properties. For example, main activity has a profile image which firstly wasn't rounded:

    .load("https://uxwing.com/wp-content/themes/uxwing/download/peoples-avatars/default-profile-picture-female-icon.png")
    .transition(DrawableTransitionOptions.withCrossFade(1000))
    .circleCrop()
    .into(prof);

That's it for now, **we'll be upgrading it!!**
