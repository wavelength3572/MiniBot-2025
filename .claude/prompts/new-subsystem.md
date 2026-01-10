# Create New Subsystem (Team 3572 Pattern)

Create a new subsystem following Team 3572's exact AdvantageKit pattern from 2025:

## Structure to Create
```
subsystems/[name]/
├── [Name].java                    # Main subsystem extending SubsystemBase
├── [Name]IO.java                  # IO interface with @AutoLog Inputs
├── [Name]IOSpark.java             # Real hardware (REV Spark)
├── [Name]IOVirtualSim.java        # Simulation
├── [Name]Constants.java           # All constants (CAN IDs, limits, PID)
└── [Name]Configs.java             # Spark motor configurations
```

## Steps
1. Ask for subsystem details:
   - Subsystem name
   - Hardware (motors, sensors, pneumatics)
   - Control modes (open-loop, velocity, position, custom)
   - Physical constraints (limits, ranges)
   - Whether it needs presets

2. Create IO interface with @AutoLog Inputs class
   - All sensor readings in Inputs
   - Methods for actuator control

3. Implement IOSpark for REV Spark controllers
   - Use SparkBase configuration pattern
   - Set up URCL logging
   - Configure in one block before enabling

4. Implement IOVirtualSim for simulation
   - Can be simple or full physics

5. Create Constants file
   - CAN IDs
   - Physical measurements (gear ratios, wheel radius, etc.)
   - PID gains
   - Limits (min/max positions, velocities)

6. Create Configs file
   - Spark configuration closures
   - Motor inversions, limits, PID configs

7. Create main Subsystem class
   - Extend SubsystemBase
   - Use @AutoLogOutput for calculated values
   - Use @Getter from Lombok where appropriate
   - Add Alert for hardware disconnects
   - Implement periodic() for logging

8. Add to RobotContainer

9. Create command classes

10. Add dashboard tuning values

## Reference 2025 Examples
- Simple: `Robot-2025/subsystems/algae/`
- Complex: `Robot-2025/subsystems/coral/elevator/`
- Composite: `Robot-2025/subsystems/coral/CoralSystem.java`
