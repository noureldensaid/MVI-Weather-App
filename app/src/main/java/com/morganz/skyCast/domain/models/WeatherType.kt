package com.morganz.skyCast.domain.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.morganz.skyCast.ui.theme.clearSkyColor
import com.morganz.skyCast.ui.theme.denseDrizzleColor
import com.morganz.skyCast.ui.theme.denseFreezingDrizzleColor
import com.morganz.skyCast.ui.theme.depositingRimeFogColor
import com.morganz.skyCast.ui.theme.foggyColor
import com.morganz.skyCast.ui.theme.heavyFreezingRainColor
import com.morganz.skyCast.ui.theme.heavyHailThunderstormColor
import com.morganz.skyCast.ui.theme.heavyRainColor
import com.morganz.skyCast.ui.theme.heavySnowFallColor
import com.morganz.skyCast.ui.theme.heavySnowShowersColor
import com.morganz.skyCast.ui.theme.lightDrizzleColor
import com.morganz.skyCast.ui.theme.mainlyClearColor
import com.morganz.skyCast.ui.theme.moderateDrizzleColor
import com.morganz.skyCast.ui.theme.moderateRainColor
import com.morganz.skyCast.ui.theme.moderateRainShowersColor
import com.morganz.skyCast.ui.theme.moderateSnowFallColor
import com.morganz.skyCast.ui.theme.moderateThunderstormColor
import com.morganz.skyCast.ui.theme.overcastColor
import com.morganz.skyCast.ui.theme.partlyCloudyColor
import com.morganz.skyCast.ui.theme.slightHailThunderstormColor
import com.morganz.skyCast.ui.theme.slightRainColor
import com.morganz.skyCast.ui.theme.slightRainShowersColor
import com.morganz.skyCast.ui.theme.slightSnowFallColor
import com.morganz.skyCast.ui.theme.slightSnowShowersColor
import com.morganz.skyCast.ui.theme.snowGrainsColor
import com.morganz.skyCast.ui.theme.violentRainShowersColor
import com.morganz.skycast.R

sealed class WeatherType(
    val weatherDesc: String,
    @DrawableRes val iconRes: Int,
    val color: Color = Color.Transparent
) {
    data object ClearSky : WeatherType(
        weatherDesc = "Clear sky",
        iconRes = R.drawable.ic_sunny,
        color = clearSkyColor
    )

    data object MainlyClear : WeatherType(
        weatherDesc = "Mainly clear",
        iconRes = R.drawable.ic_cloudy,
        color = mainlyClearColor
    )

    data object PartlyCloudy : WeatherType(
        weatherDesc = "Partly cloudy",
        iconRes = R.drawable.ic_cloudy,
        color = partlyCloudyColor
    )

    data object Overcast : WeatherType(
        weatherDesc = "Overcast",
        iconRes = R.drawable.ic_cloudy,
        color = overcastColor
    )

    data object Foggy : WeatherType(
        weatherDesc = "Foggy",
        iconRes = R.drawable.ic_very_cloudy,
        color = foggyColor

    )

    data object DepositingRimeFog : WeatherType(
        weatherDesc = "Depositing rime fog",
        iconRes = R.drawable.ic_very_cloudy,
        color = depositingRimeFogColor
    )

    data object LightDrizzle : WeatherType(
        weatherDesc = "Light drizzle",
        iconRes = R.drawable.ic_rainshower,
        color = lightDrizzleColor
    )

    data object ModerateDrizzle : WeatherType(
        weatherDesc = "Moderate drizzle",
        iconRes = R.drawable.ic_rainshower,
        color = moderateDrizzleColor
    )

    data object DenseDrizzle : WeatherType(
        weatherDesc = "Dense drizzle",
        iconRes = R.drawable.ic_rainshower,
        color = denseDrizzleColor
    )

    data object LightFreezingDrizzle : WeatherType(
        weatherDesc = "Slight freezing drizzle",
        iconRes = R.drawable.ic_snowyrainy,
        color = lightDrizzleColor
    )

    data object DenseFreezingDrizzle : WeatherType(
        weatherDesc = "Dense freezing drizzle",
        iconRes = R.drawable.ic_snowyrainy,
        color = denseFreezingDrizzleColor
    )

    data object SlightRain : WeatherType(
        weatherDesc = "Slight rain",
        iconRes = R.drawable.ic_rainy,
        color = slightRainColor
    )

    data object ModerateRain : WeatherType(
        weatherDesc = "Rainy",
        iconRes = R.drawable.ic_rainy,
        color = moderateRainColor
    )

    data object HeavyRain : WeatherType(
        weatherDesc = "Heavy rain",
        iconRes = R.drawable.ic_rainy,
        color = heavyRainColor
    )

    data object HeavyFreezingRain : WeatherType(
        weatherDesc = "Heavy freezing rain",
        iconRes = R.drawable.ic_snowyrainy,
        color = heavyFreezingRainColor
    )

    data object SlightSnowFall : WeatherType(
        weatherDesc = "Slight snow fall",
        iconRes = R.drawable.ic_snowy,
        color = slightSnowFallColor
    )

    data object ModerateSnowFall : WeatherType(
        weatherDesc = "Moderate snow fall",
        iconRes = R.drawable.ic_heavysnow,
        color = moderateSnowFallColor
    )

    data object HeavySnowFall : WeatherType(
        weatherDesc = "Heavy snow fall",
        iconRes = R.drawable.ic_heavysnow,
        color = heavySnowFallColor
    )

    data object SnowGrains : WeatherType(
        weatherDesc = "Snow grains",
        iconRes = R.drawable.ic_heavysnow,
        color = snowGrainsColor
    )

    data object SlightRainShowers : WeatherType(
        weatherDesc = "Slight rain showers",
        iconRes = R.drawable.ic_rainshower,
        color = slightRainShowersColor
    )

    data object ModerateRainShowers : WeatherType(
        weatherDesc = "Moderate rain showers",
        iconRes = R.drawable.ic_rainshower,
        color = moderateRainShowersColor
    )

    data object ViolentRainShowers : WeatherType(
        weatherDesc = "Violent rain showers",
        iconRes = R.drawable.ic_rainshower,
        color = violentRainShowersColor
    )

    data object SlightSnowShowers : WeatherType(
        weatherDesc = "Light snow showers",
        iconRes = R.drawable.ic_snowy,
        color = slightSnowShowersColor
    )

    data object HeavySnowShowers : WeatherType(
        weatherDesc = "Heavy snow showers",
        iconRes = R.drawable.ic_snowy,
        color = heavySnowShowersColor
    )

    data object ModerateThunderstorm : WeatherType(
        weatherDesc = "Moderate thunderstorm",
        iconRes = R.drawable.ic_thunder,
        color = moderateThunderstormColor
    )

    data object SlightHailThunderstorm : WeatherType(
        weatherDesc = "Thunderstorm with slight hail",
        iconRes = R.drawable.ic_rainythunder,
        color = slightHailThunderstormColor
    )

    data object HeavyHailThunderstorm : WeatherType(
        weatherDesc = "Thunderstorm with heavy hail",
        iconRes = R.drawable.ic_rainythunder,
        color = heavyHailThunderstormColor
    )

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when (code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}