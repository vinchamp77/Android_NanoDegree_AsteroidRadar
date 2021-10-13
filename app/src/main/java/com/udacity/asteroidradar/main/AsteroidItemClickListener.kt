package com.udacity.asteroidradar.main

import com.udacity.asteroidradar.Asteroid

class AsteroidItemClickListener(val clickListener: (Asteroid) -> Unit) {
    fun onClick(data: Asteroid) = clickListener(data)
}