package com.ababu.mobiledevproject.common


import java.util.Properties
import javax.mail.Authenticator
import javax.mail.Message
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage


class EmailSender {
    fun sendEmail(subject: String, recipient: String, content: String) {
        val properties = Properties().apply {
            put("mail.smtp.host", "smtp.gmail.com")
            put("mail.smtp.socketFactory.port", "465")
            put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory")
            put("mail.smtp.auth", "true")
            put("mail.smtp.port", "465")
        }

        val session = Session.getInstance(properties, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication("your_email@gmail.com", "your_password")
            }
        })

        try {
            val message = MimeMessage(session).apply {
                setFrom(InternetAddress("your_email@gmail.com"))
                setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient))
                setSubject(subject)
                setText(content)
            }

            Transport.send(message)
            println("Email sent successfully.")
        } catch (e: Exception) {
            e.printStackTrace()
            println("Failed to send email: ${e.message}")
        }
    }
}






