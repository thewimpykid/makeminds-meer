package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Extension extends SubsystemBase {
    private Motor extensionMotor;
    private Servo wrist;
    private Servo claw;

    PIDFController pidfController;

    private double targetPos = 0;
    private boolean atTargetPos = false;
    double tolerance;
    public Extension(final HardwareMap hardwareMap, final String extensionMotor, final String wrist, final String claw, double kP, double kI, double kD, double kF, double tol) {
        this.extensionMotor = hardwareMap.get(Motor.class, extensionMotor);
        this.wrist = hardwareMap.get(Servo.class, wrist);
        this.claw = hardwareMap.get(Servo.class, claw);

        pidfController = new PIDFController(kP, kI, kD, kF);
        tolerance = tol;
    }

    public void grab() {
        claw.setPosition(0);
    }

    public void setNewTarget(double targetPos) {
        this.targetPos = targetPos;
    }

    public void release() {
        claw.setPosition(1);
    }

    @Override
    public void periodic() {
        double pos = extensionMotor.getCurrentPosition();
        double command = pidfController.calculate(pos);
        extensionMotor.set(command);
    }

}
