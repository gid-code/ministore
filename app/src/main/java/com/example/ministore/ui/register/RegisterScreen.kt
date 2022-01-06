package com.example.ministore.ui.register

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
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
import androidx.compose.ui.text.TextStyle
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
import com.example.ministore.data.model.User
import com.example.ministore.ui.Screen
import com.example.ministore.ui.component.StandardTextField
import com.example.ministore.ui.login.LoginScreen
import io.paperdb.Paper

@Composable
fun RegisterScreen(
    navController: NavController
){
    val fullname = remember { mutableStateOf( "")}
    val email = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf( "")}
    val countryCode = remember { mutableStateOf("+233")}
    val localFocusManager = LocalFocusManager.current
    val isSubmitting = remember { mutableStateOf(false) }
    val errorState = remember { mutableStateOf(false) }
    val errorMessage = remember { mutableStateOf("") }
    val emailErrMsg = remember { mutableStateOf("") }
    val phoneErrMsg = remember { mutableStateOf("")}

    //register
    val registerFun: ()->Unit = {

            if(phone.value.isEmpty()) {
                errorState.value = true
                phoneErrMsg.value = "Phone required"
                println(phoneErrMsg.value)
            }else if (phone.value.length < 9 || phone.value.length > 10){
                    errorState.value = true
                    phoneErrMsg.value = "Phone not valid"
                    println(phoneErrMsg.value)
                }
            else{
                phoneErrMsg.value = ""
            }


            if(email.value.isEmpty()) {
                errorState.value = true
                emailErrMsg.value = "Email required"
            }else{
                emailErrMsg.value = ""
            }
            if(fullname.value.isEmpty()) {
                errorState.value = true
                errorMessage.value = "Full name required"
            }else{
                errorMessage.value = ""
            }
            if(errorMessage.value.isEmpty() && emailErrMsg.value.isEmpty() && phoneErrMsg.value.isEmpty()){
                errorState.value = false
                errorMessage.value = ""
                phoneErrMsg.value = ""
                emailErrMsg.value = ""
                isSubmitting.value = true

                val phoneNumber : String = if (phone.value[0] == '0'){
                    countryCode.value+phone.value.drop(1)
                }else{
                    countryCode.value+phone.value
                }
                println("Phone Number: $phoneNumber")

                User(fullname.value,email.value, phoneNumber)

                navController.navigate(Screen.HomeScreen.route){
                    popUpTo(Screen.LoginScreen.route){
                        inclusive = true
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
            Image(
                painterResource(id = R.drawable.shopping_res),
                contentDescription = null)
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text  = "Sign Up",
                style = MaterialTheme.typography.h2,
                fontSize = 30.sp,
                fontWeight = FontWeight.W800,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(12.dp))

            //fullname
            if (errorMessage.value.isNotEmpty()){
                Text(
                    text = errorMessage.value,
                    style = MaterialTheme.typography.subtitle1.copy(
                        color = Color.Red,
                        fontSize = 12.sp
                    )
                )
            }
            StandardTextField(
                error = errorMessage.value,
                text = fullname.value,
                onValueChange = {
                    fullname.value = it
                },
                leadingIcon =  Icons.Outlined.AccountCircle,
                singleLine = true,
                hint = "Full Name",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        localFocusManager.moveFocus(FocusDirection.Down)
                    }
                ),
            )

            Spacer(Modifier.height(8.dp))

            //email
            if (emailErrMsg.value.isNotEmpty()){
                Text(
                    text = emailErrMsg.value,
                    style = MaterialTheme.typography.subtitle1.copy(
                        color = Color.Red,
                        fontSize = 12.sp
                    )
                )
            }
            StandardTextField(
                error = emailErrMsg.value,
                text = email.value,
                onValueChange = {
                    email.value = it
                },

                leadingIcon =  Icons.Outlined.Email,
                singleLine = true,
                hint = "Email",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        localFocusManager.moveFocus(FocusDirection.Down)
                    }
                ),
            )

            Spacer(Modifier.height(8.dp))

            //phone
            if (phoneErrMsg.value.isNotEmpty()){
                Text(
                    text = phoneErrMsg.value,
                    style = MaterialTheme.typography.subtitle1.copy(
                        color = Color.Red,
                        fontSize = 12.sp
                    )
                )
            }
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                     Icons.Outlined.Phone,
                    contentDescription = "phone",
//                    modifier = Modifier.h
                )


                TextField(
                    modifier= Modifier.fillMaxWidth(0.3f),
                    value = countryCode.value,
                    onValueChange = {
                        countryCode.value = it
                    },
                    textStyle = MaterialTheme.typography.h2.copy(
                        color = Color.Black,
                        fontSize = 20.sp
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Blue,
                        disabledTextColor = Color.Transparent,
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Blue,
                        unfocusedIndicatorColor = Color.Gray,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Red
                    ),
                )

                TextField(
                    modifier= Modifier.fillMaxWidth(),
                    value = phone.value,
                    onValueChange = {
                        phone.value = it
                    },
                    placeholder = {
                        Text(
                            "Phone Number",
                            style = MaterialTheme.typography.h2,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W400,
                        )
                    },
                    textStyle = MaterialTheme.typography.h2.copy(
                        color = Color.Black,
                        fontSize = 20.sp
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone,
                    ),
                    isError = phoneErrMsg.value.isNotEmpty(),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Blue,
                        disabledTextColor = Color.Transparent,
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Blue,
                        unfocusedIndicatorColor = Color.Gray,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Red
                    ),
                )

//                StandardTextField(
//                    modifier = Modifier.fillMaxWidth(0.2f),
//                    text = "+233",
//                    onValueChange = {
//                        phone.value = it
//                    },
//                    leadingIcon =  Icons.Outlined.Phone,
//                    singleLine = true,
//                    keyboardActions = KeyboardActions(
//                    ),
//                    keyboardOptions = KeyboardOptions()
//                )

//                StandardTextField(
//                    modifier = Modifier.fillMaxWidth(0.7f),
//                    error = phoneErrMsg.value,
//                    text = phone.value,
//                    onValueChange = {
//                        phone.value = it
//                    },
//                    singleLine = true,
//                    hint = "Phone Number",
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = KeyboardType.Phone,
//                        imeAction = ImeAction.Done
//                    ),
//                    keyboardActions = KeyboardActions(
//                        onDone = {
//                            localFocusManager.clearFocus()
//                            //
//                        }
//                    ),
//                )
            }


            Spacer(Modifier.height(20.dp))

            //signup button
            TextButton(
                onClick = {

                    registerFun()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .size(width = 280.dp, height = 48.dp)
                    .clip(RoundedCornerShape(20))
                    .focusable(true)
                    .background(Color(0xFF295BE0)),
                content = {
                    if (isSubmitting.value){
                        CircularProgressIndicator(modifier = Modifier.size(36.dp),color = Color.White)
                    }else{
                        Text("Sign Up",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            style = MaterialTheme.typography.h2,
                            color = Color.White
                        )
                    }

                }
            )

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
        RegisterScreen(
            navController = navController
        )
    }

}