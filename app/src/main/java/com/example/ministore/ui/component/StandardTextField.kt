package com.example.ministore.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun StandardTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    maxLength: Int = 40,
    error: String = "",
    style: TextStyle = MaterialTheme.typography.h2.copy(
        color = Color.Black,
        fontSize = 20.sp
    ),
    singleLine: Boolean = true,
    maxLines: Int = 1,
    leadingIcon: ImageVector,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    onValueChange: (String) -> Unit
){
    TextField(
        value = text,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(
                imageVector =leadingIcon,
                contentDescription = null,
                tint = Color.Black
            )
        },
        singleLine = singleLine,
        placeholder = {
            Text(
                hint,
                style = MaterialTheme.typography.h2,
                fontSize = 18.sp,
                fontWeight = FontWeight.W400,
            )
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        textStyle = style,
        isError = error.isNotEmpty(),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Blue,
            disabledTextColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Blue,
            unfocusedIndicatorColor = Color.Gray,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Red
        ),
        modifier = modifier.fillMaxWidth()
    )
}