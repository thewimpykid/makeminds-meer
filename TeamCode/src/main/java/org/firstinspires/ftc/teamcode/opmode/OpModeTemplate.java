package org.firstinspires.ftc.teamcode.opmode;

import com.arcrobotics.ftclib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Extension;

abstract public class OpModeTemplate extends CommandOpMode {
    protected Extension extension;

    protected void initHardware(boolean isAuto) {
        extension = new Extension(hardwareMap, "extensionMotor",  "extensionWrist", "extensionClaw", 0.1, 0, 0, 0, 0);
        register(extension);
    }
}
