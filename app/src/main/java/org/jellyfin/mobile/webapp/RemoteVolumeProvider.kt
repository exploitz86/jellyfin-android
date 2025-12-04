package org.jellyfin.mobile.webapp

import android.media.AudioManager
import android.media.VolumeProvider
import org.jellyfin.mobile.utils.Constants
import org.jellyfin.mobile.utils.Constants.PLAYBACK_MANAGER_COMMAND_VOL_DOWN
import org.jellyfin.mobile.utils.Constants.PLAYBACK_MANAGER_COMMAND_VOL_UP

class RemoteVolumeProvider(
    private val webappFunctionChannel: WebappFunctionChannel,
) : VolumeProvider(VOLUME_CONTROL_ABSOLUTE, Constants.PERCENT_MAX, 0) {
    override fun onAdjustVolume(direction: Int) {
        // ✅ VOLUME CONTROL FIX: Disabled to prevent hijacking hardware volume buttons
        // This allows the system to handle volume button presses normally
        // 
        // Original code that caused the volume control issue:
        // when (direction) {
        //     AudioManager.ADJUST_RAISE -> {
        //         webappFunctionChannel.callPlaybackManagerAction(PLAYBACK_MANAGER_COMMAND_VOL_UP)
        //         currentVolume += 2
        //     }
        //     AudioManager.ADJUST_LOWER -> {
        //         webappFunctionChannel.callPlaybackManagerAction(PLAYBACK_MANAGER_COMMAND_VOL_DOWN)
        //         currentVolume -= 2
        //     }
        // }
    }

    override fun onSetVolumeTo(volume: Int) {
        // ✅ VOLUME CONTROL FIX: Disabled to prevent programmatic volume control
        // This allows the system to handle volume changes normally
        //
        // Original code:
        // webappFunctionChannel.setVolume(volume)
        // currentVolume = volume
    }
}
