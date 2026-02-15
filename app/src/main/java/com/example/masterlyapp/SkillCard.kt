package com.example.masterlyapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.masterlyapp.ui.theme.rojerFlintFontFamily
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
@Composable
fun SkillCard(
    skill: Skill
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2E2E3A))
    ) {
        Card(
            colors = CardColors(
                containerColor = Color.Transparent, contentColor = Color.White,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.Black
            ),
            border = BorderStroke(1.dp, Color.Gray),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.padding(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, top = 20.dp, end = 20.dp)
                ) {
                    Text(

                        text = skill.skillTitle,
                        maxLines = 2,
                        fontSize = 20.sp,
                        fontFamily = rojerFlintFontFamily,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier.width(220.dp)
                    )
                    Icon(
                        painterResource(R.drawable.arrow_expand),
                        contentDescription = "Expand Arrow Icon",
                        modifier = Modifier
                            .rotate(90f)
                            .size(32.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, bottom = 16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "${skill.skillProgress}%",
                            fontSize = 24.sp,
                            fontFamily = rojerFlintFontFamily,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "/ ${skill.totalDays} days",
                            fontSize = 16.sp,
                            fontFamily = rojerFlintFontFamily,
                            color = Color.Gray
                        )
                    }
                    Text(
                        text = skill.startDate,
                        fontSize = 16.sp,
                        fontFamily = rojerFlintFontFamily,
                        color = Color.Gray
                    )
                }
            }
        }
    }

}

@Preview
@Composable
private fun SkillCardPreview() {

    val currDate = LocalDateTime.now()
    val res = DateTimeFormatter.ofPattern("dd.MM.yyyy").format(currDate)
    SkillCard(
        Skill(
            id = 1,
            skillTitle = "Reading program: 6 development books",
            skillProgress = 11,
            totalDays = 90,
            startDate = res
        )
    )
}
