# 2025 Robot Code Analysis - Team Wavelength 3572

## Overview
Your 2025 robot was already built with **AdvantageKit**, which is excellent! You have a solid foundation to build upon for 2026. This analysis will help carry forward your best practices and identify areas for potential improvement.

## 🏗️ Architecture

### Subsystems Implemented (2025)
1. **Drive (Swerve)** - 4-wheel swerve drive with custom odometry threading
2. **Algae** - Game piece manipulator
3. **Climber** - End-game climbing mechanism
4. **Coral System** - Complex multi-component system:
   - **Arm** - Articulated arm mechanism
   - **Elevator** - Linear elevator
   - **Intake** - Game piece intake
5. **Vision** - PhotonVision integration with pose estimation
6. **LED/Indicator Lights** - Driver feedback system

### Hardware Stack
- **Motor Controllers**: REV Spark (primary), some CTRE devices
- **Gyro**: CTRE Pigeon 2
- **Vision**: PhotonVision cameras
- **Drive**: Swerve modules with Spark controllers

### Software Libraries
- ✅ AdvantageKit (already using!)
- ✅ PathPlanner 2025.2.6 (autonomous pathfinding)
- ✅ Phoenix 6 (v25.3.2) (CTRE hardware)
- ✅ REVLib (Spark controllers)
- ✅ PhotonLib (vision)
- ✅ URCL (Unofficial REV-Compatible Logger)
- ✅ Lombok (code generation with @Getter, etc.)

## 🎯 Excellent Patterns You Already Follow

### 1. **Perfect AdvantageKit IO Layer Pattern** ✨
Your subsystems follow the ideal structure:
```
subsystem/
├── Subsystem.java          # Main subsystem logic
├── SubsystemIO.java        # IO interface with @AutoLog Inputs
├── SubsystemIOSpark.java   # Real hardware implementation
├── SubsystemIOVirtualSim.java  # Simulation implementation
├── SubsystemConstants.java # Configuration constants
└── SubsystemConfigs.java   # Motor configurations
```

**Why this is great:**
- Clean separation of concerns
- Full replay capability
- Easy to test and simulate
- Follows AdvantageKit best practices exactly

### 2. **Advanced Features**
- **Thread priority management** in robotPeriodic() for consistent loop timing
- **URCL integration** for detailed Spark controller logging
- **Custom odometry threading** (SparkOdometryThread) for better odometry updates
- **Pose estimator redundancy** (poseEstimator2) for validation
- **3D visualization** integration
- **Odometry health monitoring** for detecting problems
- **Custom alignment strategies** (Strategy pattern) for different scoring positions
- **Elastic dashboard** integration with auto-tab switching
- **ReefScoringLogger** for match analysis

### 3. **Code Quality Features**
- **Spotless** for automatic code formatting
- **Lombok** for reducing boilerplate (@Getter, etc.)
- **Proper logging** of all inputs/outputs
- **Alert system** for hardware issues (gyro disconnected, etc.)
- **Tuning mode** flag for competition vs. practice

### 4. **Vision Integration**
- PhotonVision with pose estimation
- Vision data fed into SwerveDrivePoseEstimator
- Configurable vision standard deviations
- Vision can be toggled on/off

## 📊 Code Statistics

### Subsystem Complexity
| Subsystem | IO Implementations | Lines of Code (approx) |
|-----------|-------------------|----------------------|
| Drive | Spark + Sim | High - Full swerve |
| Coral System | 3 sub-subsystems | Very High - Composite |
| Algae | Spark + VirtualSim | Medium |
| Climber | Spark + VirtualSim | Medium |
| Vision | PhotonVision + Sim | Medium |
| LEDs | Direct control | Low |

## 🔄 What's Reusable for 2026?

### Directly Reusable (Copy & Modify)
1. **Drive subsystem** - Your swerve implementation is solid
   - SparkOdometryThread for better odometry
   - Module and ModuleIO patterns
   - PathPlanner integration
   - Vision fusion

2. **Utility classes**
   - `AlignmentUtils` - Target selection helpers
   - `BranchAlignmentUtils` - Alignment calculations
   - `LocalADStarAK` - Custom pathfinding
   - `Elastic` - Dashboard management
   - `RobotStatus` - State tracking

3. **Vision system** - If using PhotonVision again

4. **LED/Indicator system** - Driver feedback patterns

### Patterns to Replicate
1. **Composite subsystem pattern** (CoralSystem) - For complex mechanisms with multiple components
2. **Strategy pattern** (Alignment strategies) - For different autonomous behaviors
3. **Preset system** (CoralSystemPresets) - For mechanism positions
4. **Health monitoring** - Odometry and system health checks

### What Needs Rethinking
1. **Game-specific subsystems** - Obviously 2026 game is different
2. **Alignment strategies** - Will need 2026 field targets
3. **Constants** - Will need re-tuning for new robot dimensions/weight

## 💡 Suggestions for 2026

### Architecture Improvements
1. **Continue your IO layer pattern** - It's perfect, keep doing it
2. **Consider extracting common patterns** - You have reusable code in multiple subsystems (PID control, state machines, etc.)
3. **Add more simulation** - Some subsystems only have VirtualSim, consider full physics sim
4. **Document preset values** - Add comments explaining why certain preset positions were chosen

### Code Quality
1. **Add unit tests** - Your IO layer makes this easy
2. **Document alignment math** - Complex alignment calculations could use more comments
3. **Extract magic numbers** - Some constants are still hardcoded in places

### Performance
1. **Monitor loop overruns** - You already adjust watchdog timeout, continue monitoring
2. **Profile pathfinding** - LocalADStarAK custom implementation should be benchmarked
3. **Vision latency** - Continue monitoring vision update rates

## 🎓 Team Knowledge Capture

### Your Team's Conventions
- **Package structure**: Each subsystem in its own package with all related classes
- **Naming**: `SubsystemIO`, `SubsystemIOSpark`, `SubsystemIOVirtualSim`
- **Constants**: Both `Constants.java` and subsystem-specific constants files
- **Motor configs**: Separate `Configs` classes for Spark configuration
- **Lombok usage**: `@Getter` for reducing boilerplate
- **Alliance awareness**: Code accounts for field flipping
- **Smart driving modes**: Support for different drive modes based on context

### PID/Control Patterns
- Use Spark built-in PID when possible
- Closed-loop control through IO layer
- State-based control for complex mechanisms
- Preset positions for common mechanism states

### Safety Features
- Alert system for hardware disconnects
- Odometry health monitoring
- Vision quality checking
- Loop overrun detection

## 🚀 Kickoff Preparation Checklist

### Before Kickoff
- [x] Clone 2025 code for reference
- [x] Set up 2026 skeleton with AdvantageKit
- [x] Configure Claude for FRC development
- [ ] Review game manual when released
- [ ] Identify reusable subsystems

### During Kickoff Weekend
- [ ] Analyze game tasks and strategy
- [ ] Sketch robot mechanisms needed
- [ ] Identify which 2025 patterns apply
- [ ] Plan autonomous strategies
- [ ] Assign subsystems to team members

### First Week Post-Kickoff
- [ ] Copy drive subsystem to 2026 project (if dimensions similar)
- [ ] Set up vision system (if using PhotonVision again)
- [ ] Create new game-specific subsystems using your IO pattern
- [ ] Set up PathPlanner for new field
- [ ] Configure AdvantageScope layouts for new mechanisms

## 📋 Quick Reference

### Your Build Commands
```bash
./gradlew build          # Compile
./gradlew deploy         # Deploy to robot
./gradlew simulateJava   # Run simulation
./gradlew spotlessApply  # Format code
```

### Your CAN IDs (2025 - for reference)
**Drive:**
- Front Right: Drive=3, Turn=7
- Front Left: Drive=5, Turn=9
- Back Right: Drive=6, Turn=2
- Back Left: Drive=8, Turn=4

*Note: These will likely change for 2026 robot*

### Key Files to Reference
- `Robot.java` - Main robot initialization and URCL setup
- `RobotContainer.java` - Command bindings and subsystem instantiation
- `DriveConstants.java` - Drivetrain configuration
- `FieldConstants.java` - Field dimensions and positions

## 🎯 Bottom Line

Your 2025 code is **excellent**. You're already following AdvantageKit best practices, have advanced features like custom odometry threading and vision fusion, and maintain clean code organization.

**For 2026, focus on:**
1. **Reuse your drive subsystem** - It's solid
2. **Apply your IO pattern** to new game-specific mechanisms
3. **Leverage your utility classes** and patterns
4. **Continue your logging and visualization** practices
5. **Build on your alignment strategy** pattern for new game tasks

Your team is well-prepared for a successful 2026 season! 🤖🏆
