package com.example.ucp1pam

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ucp1pam.R.drawable.shoppe

@Preview(showBackground = true)
@Composable
fun UserInput(modifier: Modifier = Modifier){
    var email by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var tahunmasuk by remember { mutableStateOf("") }

    val datatahunmasuk = listOf("2020","2021","2022")

    var confemail by remember { mutableStateOf("") }
    var confalamat by remember { mutableStateOf("") }
    var confnotelepon by remember { mutableStateOf("") }
    var conftahunmasuk by remember { mutableStateOf("") }

    Column ( modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        HeaderSection()
        TextField(
            value = email,
            onValueChange = {email = it},
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "Isi Email Anda")
            },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = notelepon,
            onValueChange = {notelepon = it},
            label = {
                Text(text = "No Telepon")
            },
            placeholder = {
                Text(text = "Isi No Telpon Anda")
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            label = {
                Text(text = "Alamat")
            },
            placeholder = {
                Text(text = "Isi Alamat Anda")
            },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = tahunmasuk,
            onValueChange = {tahunmasuk = it},
            label = {
                Text(text = "Tahun Masuk")
            },
            placeholder = {
                Text(text = "Isi Tahun Masuk Anda")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(8.dp))
        Row (modifier = Modifier.fillMaxWidth()) {
            datatahunmasuk.forEach { selectedTahun ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = tahunmasuk == selectedTahun,
                        onClick = { tahunmasuk = selectedTahun })
                    Text(text = selectedTahun)
                }
            }
        }

        Button(onClick = {
            
            confemail = email
            confalamat= alamat
            confnotelepon = notelepon
            conftahunmasuk = tahunmasuk
            
        }
        ) {
            Text(text = "Simpan")
        }

        TampilData(
            param = "Email",
            argu = confemail)
        TampilData(
            param = "Alamat",
            argu = confalamat)
        TampilData(
            param = "No Telepon",
            argu = confnotelepon)
        TampilData(
            param = "Tahun Masuk",
            argu = conftahunmasuk)
    }
}



@Composable
fun HeaderSection() {
    Column {
        Box(
            modifier = Modifier.fillMaxWidth()
                .background(Color.LightGray)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Box(
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Image(
                        painter = painterResource(id = shoppe),
                        contentDescription = null,
                        modifier = Modifier.clip(CircleShape).
                        size(75.dp)

                    )
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                            .background(Color.Green)
                    )
                }
                Column(
                    modifier = Modifier.padding(14.dp)
                ) {
                    Text(text = "Daftar Driver Shoppe Food", fontWeight = FontWeight.Bold)
                    Text(text = "")
                }
            }
        }
    }
}

@Composable
fun TampilData(
    param:String, argu:String
    ) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = param,
                modifier = Modifier.weight(0.8f)
            )
            Text(
                text = ":",
                modifier = Modifier.weight(0.2f)
            )
            Text(
                text = argu,
                modifier = Modifier.weight(2f)
            )
        }
    }
}