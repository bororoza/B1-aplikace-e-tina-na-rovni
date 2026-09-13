package com.example.ui.theme

import androidx.compose.ui.graphics.Color

// =================================================================
// PALETTE: "Čeština na úrovni B1" (Inspired by official puzzle logo)
// =================================================================

// 1. Logo Magenta / Fuchsia Pink (Core Brand Color from Puzzle Pieces)
val LogoPink = Color(0xFFD8288D)          // Main puzzle magenta
val LogoPinkDark = Color(0xFFA51366)      // Deep fuchsia for dark accents
val LogoPinkLight = Color(0xFFFCE7F3)     // Soft pastel fuchsia background
val LogoPinkSoft = Color(0xFFFFF1F8)      // Ultra-soft card background
val LogoPinkBorder = Color(0xFFF472B6)    // Playful border tone

// 2. Logo Sunshine Gold / Yellow (Rays, Stars, Arrows, Thumbs-up)
val LogoYellow = Color(0xFFFFB800)        // Warm sunshine doodle yellow
val LogoYellowDark = Color(0xFFD97706)    // Amber accent
val LogoYellowLight = Color(0xFFFEF3C7)   // Soft yellow badge highlight
val LogoYellowSoft = Color(0xFFFFFBEB)    // Lightest yellow tint

// 3. Czech Flag Colors (from the circular badge on the logo)
val CzechBlue = Color(0xFF11457E)         // National Czech blue
val CzechBlueDark = Color(0xFF0C2E54)     // Deep navy
val CzechBlueLight = Color(0xFFDBEAFE)    // Light sky blue tint
val CzechRed = Color(0xFFD7141A)          // National Czech red
val CzechRedLight = Color(0xFFFEE2E2)     // Light red tint

// 4. Playful Doodle Ink / Charcoal (Sketch lines from the logo)
val DoodleBlack = Color(0xFF1C1917)       // Warm sketch ink black
val DoodleDark = Color(0xFF292524)        // Dark charcoal
val DoodleBorder = Color(0xFF44403C)      // Border outline
val DoodleMuted = Color(0xFF78716C)       // Muted pencil text
val DoodleSoft = Color(0xFFA8A29E)        // Light sketch hint

// 5. Canvas & Card Surfaces (Clean white paper feel matching the logo)
val CanvasBg = Color(0xFFFFFFFF)          // Crisp white canvas
val CanvasWhite = Color(0xFFFFFFFF)       // Crisp white cards
val CanvasCardBg = Color(0xFFFFFFFF)      // Pure white card surfaces
val CanvasBorder = Color(0xFFE2E8F0)      // Clean border

// Backward compatibility mappings with old palette
val PrimaryIndigo = LogoPink
val PrimaryDark = LogoPinkDark
val PrimaryLight = LogoPinkLight
val PrimaryAccent = LogoPink

val SecondaryEmerald = CzechBlue
val SecondaryEmeraldDark = CzechBlueDark
val SecondaryEmeraldLight = CzechBlueLight
val SecondaryEmeraldAccent = Color(0xFF0284C7)

val AccentAmber = LogoYellow
val AccentAmberLight = LogoYellowLight

val Slate950 = DoodleBlack
val Slate900 = DoodleDark
val Slate800 = Color(0xFF292524)
val Slate700 = Color(0xFF44403C)
val Slate600 = Color(0xFF57534E)
val Slate500 = DoodleMuted
val Slate400 = DoodleSoft
val Slate300 = Color(0xFFD6D3D1)
val Slate200 = Color(0xFFE7E5E4)
val Slate100 = Color(0xFFF5F5F4)
val Slate50 = CanvasBg

val Rose600 = LogoPink
val Rose100 = LogoPinkLight
val Rose50 = LogoPinkSoft
