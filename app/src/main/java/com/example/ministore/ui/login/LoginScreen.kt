package com.example.ministore.ui.login

import android.content.Intent
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ministore.R
import com.example.ministore.ui.Screen
import com.example.ministore.ui.component.StandardTextField
import com.example.ministore.ui.theme.MiniStoreTheme
import com.example.ministore.ui.theme.PrimaryBlue
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@Composable
fun LoginScreen(
    navController: NavController
){
    val localFocusManager = LocalFocusManager.current
    val isSubmitting = remember { mutableStateOf(false) }
    val errorState = remember { mutableStateOf(false) }
    val phone = remember { mutableStateOf( "")}
    val errorMessage = remember { mutableStateOf("") }

    val loginFun: ()->Unit = {
        when {
            phone.value.isEmpty() -> {
                errorState.value = true
                errorMessage.value = "Phone required"
            }
            else -> {
                errorState.value = false
                errorMessage.value = ""

                isSubmitting.value = true

                navController.navigate(Screen.HomeScreen.route){
                    popUpTo(Screen.LoginScreen.route){
                        inclusive = true
                    }
                }

            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        ){

            Image(painterResource(id = R.drawable.shopping),
            contentDescription = null)
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text  = "Login",
                style = MaterialTheme.typography.h2,
                fontSize = 30.sp,
                fontWeight = FontWeight.W800,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(12.dp))

            //phone textfield
            StandardTextField(
                error = errorMessage.value,
                text = phone.value,
                onValueChange = {
                    phone.value = it
                },
                leadingIcon =  Icons.Outlined.Phone,
                singleLine = true,
                hint = "Your Phone Number",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        localFocusManager.clearFocus()
                        loginFun()
                    }
                ),
            )
            Spacer(Modifier.height(18.dp))
            //login button
            TextButton(
                onClick = loginFun,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(width = 280.dp, height = 48.dp)
                    .clip(RoundedCornerShape(20))
                    .focusable(true)
                    .background(PrimaryBlue),
                content = {
                    if (isSubmitting.value){
                        CircularProgressIndicator(modifier = Modifier.size(36.dp),color = Color.White)
                    }else{
                        Text("Login",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            style = MaterialTheme.typography.h2,
                            color = Color.White
                        )
                    }

                }
            )

            Spacer(Modifier.height(18.dp))

            Row{
                Text("New to MiniStore?",
                    style = MaterialTheme.typography.body1,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.Gray
                )
                Spacer(Modifier.width(5.dp))
                Text("Register",
                    style = MaterialTheme.typography.body1,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500,
                    color = Color(0xFF295BE0),
                    modifier = Modifier.clickable {
                        navController.navigate(Screen.RegisterScreen.route)
                    }
                )
            }

        }
    }
}

@Preview(backgroundColor = 0xFFFFFF, uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.PIXEL_4 )
@Composable
fun Preview() {
    val navController = rememberNavController()
    Surface(
        color = Color.White
    ) {
        LoginScreen(
            navController = navController
        )
    }

}