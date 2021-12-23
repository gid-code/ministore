package com.example.ministore.ui.cart

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ministore.ui.component.CardInput
import com.example.ministore.ui.component.PaymentCard


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CardPaymentScreen(
    navController: NavController
){
    val nameText = remember { mutableStateOf(TextFieldValue()) }
    val cardNumber = remember { mutableStateOf(TextFieldValue()) }
    val expiryNumber = remember { mutableStateOf(TextFieldValue()) }
    val ccvNumber = remember { mutableStateOf(TextFieldValue()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Card Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = "close button"
                        )
                    }
                }

            )
        }
    ){
        Column(modifier = Modifier.fillMaxSize()) {
            PaymentCard(
                nameText.value,
                cardNumber.value,
                expiryNumber.value,
                ccvNumber.value
            )

            LazyColumn(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ){
                item {
                    CardInput(
                        textFieldValue = nameText.value,
                        label = "Card Holder",
                        onTextChanged = { nameText.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                }
                item {
                    CardInput(
                        textFieldValue = cardNumber.value,
                        label = "Card Number",
                        keyboardType = KeyboardType.Number,
                        onTextChanged = { cardNumber.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        visualTransformation = CreditCardFilter
                    )
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CardInput(
                            textFieldValue = expiryNumber.value,
                            label = "Expiry",
                            keyboardType = KeyboardType.Number,
                            onTextChanged = { expiryNumber.value = it },
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 8.dp)
                        )
                        CardInput(
                            textFieldValue = ccvNumber.value,
                            label = "CCV",
                            keyboardType = KeyboardType.Number,
                            onTextChanged = { ccvNumber.value = it },
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 8.dp)
                        )
                    }
                }

                item {
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Text(
                            text = "Save",
                            modifier = Modifier.padding(horizontal = 30.dp, vertical = 8.dp)
                        )
                    }
                }
            }
        }
    }
}
