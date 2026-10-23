package com.example.myapplication

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.view.TampilData
import com.example.navigation.view.FormIsian

enum class Navigasi {
    FormulirSaya,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier
) {
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.FormulirSaya.name,
            modifier = Modifier.padding(isiRuang)
        ) {
            composable(route = Navigasi.FormulirSaya.name) {
                FormIsian(
                    // pilihanJK = JenisK.map { id -> konteks.resources.getString(id) },
                    OnSubmitBtnClick = {
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name) {
                TampilData(
                    onBackBtnClick = {
                        cancelAndBackToFormulaSaya(navController)
                    }
                )
            }
        }
    }
}

private fun cancelAndBackToFormulaSaya(
    navController: NavHostController
) {
    navController.popBackStack(
        Navigasi.FormulirSaya.name,
        inclusive = false
    )
}
