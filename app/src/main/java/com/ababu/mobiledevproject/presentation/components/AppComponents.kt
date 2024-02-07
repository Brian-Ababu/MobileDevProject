@file:OptIn(ExperimentalMaterial3Api::class)

package com.ababu.mobiledevproject.presentation.components

import android.util.Log
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ababu.mobiledevproject.common.Routes
import com.ababu.mobiledevproject.data.CardData
import com.ababu.mobiledevproject.presentation.ui.theme.AccentColor
import com.ababu.mobiledevproject.presentation.ui.theme.BgColor
import com.ababu.mobiledevproject.presentation.ui.theme.Primary
import com.ababu.mobiledevproject.presentation.ui.theme.Secondary
import com.ababu.mobiledevproject.presentation.ui.theme.TextColor
@Composable
        /**
         * Displays the provided text value as a centered text with a specific style and color.
         *
         * @param value The text value to be displayed.
         */
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}
@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
        /**
         * Creates a text field component with an outlined style.
         *
         * @param labelValue The label for the text field.
         * @param icon The leading icon for the text field.
         */
fun MyTextFieldComponent(icon: ImageVector, label: String, value: TextFieldValue, onValueChange: (TextFieldValue) -> Unit) {

    Column {

        Text(text = label)
        OutlinedTextField(

            label = { Text(text = label) },
            value = value,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = AccentColor,
                focusedLabelColor = AccentColor,
                cursorColor = Primary,
                containerColor = BgColor,
                focusedLeadingIconColor = AccentColor

            ),
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            leadingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = "profile"
                )
            },
            /**
             * Sets the keyboard options for an input field to the default options.
             *
             * Example Usage:
             * ```
             * keyboardOptions = KeyboardOptions.Default
             * ```
             *
             * Inputs:
             * None
             *
             * Flow:
             * 1. Sets the `keyboardOptions` property of an input field.
             * 2. Sets the `keyboardOptions` property to the default options.
             *
             * Outputs:
             * None
             */
            keyboardOptions = KeyboardOptions.Default
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
        /**
         * Creates a composable function that generates a password text field with a leading icon, a trailing icon for toggling password visibility, and custom styling.
         *
         * @param labelValue The label text for the text field.
         * @param icon The icon to be displayed as the leading icon.
         */
fun PasswordTextFieldComponent(icon: ImageVector, labelValue: String, label: String, value: TextFieldValue, onValueChange: (TextFieldValue) -> Unit ) {
    /**
     * Defines a mutable state variable called 'password' using the 'remember' function from the Jetpack Compose library.
     *
     * Example Usage:
     * ```kotlin
     * var password by remember {
     * mutableStateOf("")
     * }
     * ```
     *
     * Inputs: None
     *
     * Flow:
     * 1. The 'remember' function is called with a lambda expression as its argument.
     * 2. Inside the lambda expression, the 'mutableStateOf' function is called with an empty string as its argument.
     * 3. The 'mutableStateOf' function returns a mutable state variable of type 'String' with an initial value of an empty string.
     * 4. The 'by' keyword is used to delegate the variable assignment to the mutable state variable returned by 'mutableStateOf'.
     * 5. The 'password' variable is assigned the value of the mutable state variable.
     *
     * Outputs: None
     */
    var password by remember {
        mutableStateOf("")
    }
    /**
     * Defines a mutable state variable to track whether the password text should be visible or hidden.
     *
     * Example Usage:
     * ```
     * var isPasswordVisible by remember {
     * mutableStateOf(false)
     * }
     * ```
     *
     * Inputs: None
     *
     * Flow:
     * 1. The `remember` function is used to create a mutable state variable called `isPasswordVisible`.
     * 2. The `isPasswordVisible` variable is initialized with a default value of `false`.
     *
     * Outputs:
     * - The `isPasswordVisible` variable is a boolean value that can be used to determine whether the password text should be visible or hidden.
     */
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    Column {
        Text(text = label)
        OutlinedTextField(
            label = {
                Text(text = labelValue)
            },
            value = value,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = AccentColor,
                focusedLabelColor = AccentColor,
                cursorColor = Primary,
                containerColor = BgColor,
                focusedLeadingIconColor = AccentColor,

            ),
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            leadingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = "profile"
                )
            },
            trailingIcon = {

                val description = if (isPasswordVisible) "Show Password" else "Hide Password"

            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
        )
    }

}
@Composable
fun CheckboxComponent() {
    var isChecked by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = {
                isChecked = it
            }
        )
        ClickableTextComponent()
    }
}
@Composable
fun ClickableTextComponent() {
    val initialText = "By continuing you accept our "
    val privacyPolicyText = "Privacy Policy"
    val andText = " and "
    val termOfUseText = "Term of Use"
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = TextColor)) {
            append(initialText)
        }
        withStyle(style = SpanStyle(color = Secondary)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        withStyle(style = SpanStyle(color = TextColor)) {
            append(andText)
        }
        withStyle(style = SpanStyle(color = Secondary)) {
            pushStringAnnotation(tag = termOfUseText, annotation = termOfUseText)
            append(termOfUseText)
        }
        append(".")
    }
    ClickableText(text = annotatedString, onClick = {
        annotatedString.getStringAnnotations(it, it)
            .firstOrNull()?.also { annotation ->
                Log.d("ClickableTextComponent", "You have Clicked ${annotation.tag}")
            }
    })
}

@Composable
fun myImage(
    image: Int
){

    Image(painterResource(id = image) , contentDescription = "")
}

//Added cards to be used in the services screen for users to book their appointments

@Composable
fun ImageCardList(cardDataList: List<CardData>, navController: NavController) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(cardDataList) { cardData ->
            ImageCard(cardData = cardData, navController = navController)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ImageCard(cardData: CardData, navController: NavController) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
    ) {
        Image(
            painter = painterResource(cardData.imageResId),
            contentDescription = "Card Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)

                .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = Modifier.padding(2.dp) .clickable { navController.navigate(Routes.Booking.route) },
            text = cardData.title,
            style = MaterialTheme.typography.bodySmall
        )
    }
}