package org.firstinspires.ftc.teamcode.opmode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="ExtensionTest")
public class ExtensionTest extends OpModeTemplate {

    @Override
    public void initialize() {
        initHardware(false);
    }

    @Override
    public void run() {
        super.run();
        extension.periodic();
    }
}
