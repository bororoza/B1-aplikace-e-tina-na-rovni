package com.example.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.ui.theme.CzechBlue
import com.example.ui.theme.CzechRed
import com.example.ui.theme.DoodleBlack
import com.example.ui.theme.LogoPink
import com.example.ui.theme.LogoPinkDark
import com.example.ui.theme.LogoYellow
import com.example.ui.theme.LogoYellowLight

/**
 * Brand header displaying the official "Čeština na úrovni B1" logo emblem
 * with interlocking puzzle pieces, Czech flag badge, and doodle style accents.
 */
@Composable
fun LogoPuzzleHeader(
    modifier: Modifier = Modifier,
    showSubtitle: Boolean = true
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Logo Graphic Badge with playful comic border & shadow
        Surface(
            shape = RoundedCornerShape(18.dp),
            color = Color.White,
            shadowElevation = 6.dp,
            border = androidx.compose.foundation.BorderStroke(2.5.dp, DoodleBlack),
            modifier = Modifier.size(68.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(3.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_logo_puzzle_1788966004470),
                    contentDescription = "Čeština na úrovni B1 Logo",
                    modifier = Modifier
                        .size(62.dp)
                        .clip(RoundedCornerShape(14.dp))
                )
            }
        }

        Column(modifier = Modifier.weight(1f)) {
            // "ÚROVEŇ B1" comic sticker badge
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    color = LogoYellow,
                    shape = RoundedCornerShape(8.dp),
                    border = androidx.compose.foundation.BorderStroke(1.5.dp, DoodleBlack)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "✨ ÚROVEŇ B1",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Black,
                            color = DoodleBlack,
                            letterSpacing = 0.5.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.width(6.dp))
                Text("🇨🇿", fontSize = 14.sp)
                Text("👍", fontSize = 13.sp)
            }

            Spacer(modifier = Modifier.height(3.dp))

            // Main Title: "Čeština na úrovni B1" in bold doodle-friendly style
            Text(
                text = "Čeština na úrovni B1",
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 20.sp),
                fontWeight = FontWeight.Black,
                color = Color.White,
                letterSpacing = 0.25.sp
            )

            if (showSubtitle) {
                Text(
                    text = "30 témat ústní zkoušky • Trenažér slovíček a monologů",
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 11.sp),
                    color = Color.White.copy(alpha = 0.9f),
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

/**
 * Mini brand chip showing the logo puzzle badge for top app bars
 */
@Composable
fun LogoPuzzleMiniBadge(
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = Color.White,
        border = androidx.compose.foundation.BorderStroke(1.5.dp, DoodleBlack),
        modifier = modifier.size(34.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo_puzzle_1788966004470),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(2.dp)
                .clip(RoundedCornerShape(8.dp))
        )
    }
}
