package com.example.masterlyapp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(listOfSkills: MutableList<Skill>) {
    LazyColumn {
        items(listOfSkills) { skills->
            SkillCard(skills)
        }
    }
}