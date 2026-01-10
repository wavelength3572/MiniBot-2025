# Migrating from 2025 to 2026 Robot Code

## Quick Start Guide

### Step 1: Copy Drive Subsystem (If using swerve again)

The drive subsystem from 2025 is well-tested and reusable:

```bash
# From 2026Skeleton directory
cp -r "../Robot-2025/src/main/java/frc/robot/subsystems/drive" "src/main/java/frc/robot/subsystems/"
```

**Then update:**
1. `DriveConstants.java` - Update dimensions, gear ratios, CAN IDs for new robot
2. Check module order matches physical robot (FL, FR, BL, BR)
3. Verify gyro CAN ID in Robot.java if using Pigeon 2
4. Test in simulation before deploying

### Step 2: Copy Vision Subsystem (If using PhotonVision)

```bash
cp -r "../Robot-2025/src/main/java/frc/robot/subsystems/vision" "src/main/java/frc/robot/subsystems/"
```

**Then update:**
1. `VisionConstants.java` - Camera names, mounting positions, pipeline names
2. Update AprilTag layouts for 2026 field
3. Adjust standard deviations based on testing

### Step 3: Copy Utility Classes

Reusable utilities from 2025:

```bash
# Create util directory
mkdir -p "src/main/java/frc/robot/util"

# Copy specific utilities as needed:
cp "../Robot-2025/src/main/java/frc/robot/util/Elastic.java" "src/main/java/frc/robot/util/"
cp "../Robot-2025/src/main/java/frc/robot/util/RobotStatus.java" "src/main/java/frc/robot/util/"
# Add others as needed (AlignmentUtils, BranchAlignmentUtils, LocalADStarAK, etc.)
```

### Step 4: Update Robot.java with Team Patterns

Copy these patterns from 2025 Robot.java:

1. **URCL Setup** (lines 99-108):
```java
// Initialize URCL - map your 2026 CAN IDs
Map<Integer, String> SparkCANIDMap = new HashMap<Integer, String>();
SparkCANIDMap.put(3, "DriveFrontRight");  // Update these!
// ... add all your Spark CAN IDs
Logger.registerURCL(URCL.startExternal(SparkCANIDMap));
```

2. **Thread Priority in robotPeriodic()** (lines 163, 173):
```java
Threads.setCurrentThreadPriority(true, 99);
CommandScheduler.getInstance().run();
Threads.setCurrentThreadPriority(false, 10);
```

3. **Loop Overrun Timeout Adjustment** (lines 114-121)

### Step 5: Set Up Constants.java

Copy from 2025 and update:

```java
public static final Mode simMode = Mode.REAL;
public static final Mode currentMode = RobotBase.isReal() ? Mode.REAL : simMode;
public static final boolean tuningMode = false;  // true during development
public static final boolean isCompetition = false;  // true for competitions
```

### Step 6: Create FieldConstants.java

Based on 2026 game field:
- Field dimensions
- Target positions (AprilTags, scoring locations, etc.)
- Alliance-specific coordinates

### Step 7: Update vendordeps

Copy vendor dependencies from 2025 (they're already good):
```bash
cp ../Robot-2025/vendordeps/*.json vendordeps/
```

You'll have:
- AdvantageKit.json
- PathplannerLib.json (update version if needed)
- Phoenix6.json (update version if needed)
- photonlib.json
- REVLib.json
- URCL.json
- WPILibNewCommands.json

### Step 8: Copy build.gradle Configurations

Important sections from 2025 build.gradle:
1. JVM args for RIO 2 optimization (lines 33-43)
2. Lombok plugin configuration
3. Spotless configuration

## Creating New Game-Specific Subsystems

For new mechanisms (2026 game pieces, scoring, etc.), use your proven pattern:

### Template Checklist
1. [ ] Create subsystem package: `src/main/java/frc/robot/subsystems/[name]/`
2. [ ] Create `[Name]IO.java` with @AutoLog Inputs
3. [ ] Create `[Name]IOSpark.java` for real hardware
4. [ ] Create `[Name]IOVirtualSim.java` for simulation
5. [ ] Create `[Name]Constants.java` with all constants
6. [ ] Create `[Name]Configs.java` with Spark configurations
7. [ ] Create `[Name].java` main subsystem class
8. [ ] Add to RobotContainer instantiation
9. [ ] Create command classes in `commands/`
10. [ ] Add dashboard tuning values

## Reusable Patterns from 2025

### 1. Composite Subsystem Pattern
If you have a complex mechanism with multiple components (like 2025's CoralSystem):

**Reference:** `Robot-2025/src/main/java/frc/robot/subsystems/coral/CoralSystem.java`

Pattern:
- Create parent subsystem that holds child subsystems
- Parent coordinates child subsystems
- Each child has its own IO layer
- Use preset system for coordinated positions

### 2. Preset System
For mechanisms with common positions:

**Reference:** `Robot-2025/src/main/java/frc/robot/subsystems/coral/CoralSystemPresets.java`

```java
public class SubsystemPresets {
  public record Preset(double position1, double position2) {}

  public static final Preset STOWED = new Preset(0.0, 0.0);
  public static final Preset SCORING = new Preset(1.5, 0.8);
  // etc.
}
```

### 3. Strategy Pattern for Alignment
For different autonomous alignment approaches:

**Reference:** `Robot-2025/src/main/java/frc/robot/alignment/`

Structure:
- `AlignmentStrategy.java` - Interface
- Concrete implementations for different targets
- `StrategyManager.java` - Selects and executes strategies
- `AlignmentContext.java` - Shared context/state

### 4. Health Monitoring
Add alerts for hardware issues:

```java
private final Alert disconnectedAlert =
    new Alert("Subsystem hardware disconnected", AlertType.kError);

// In periodic():
disconnectedAlert.set(!io.inputs.connected);
```

### 5. Custom Dashboard Tabs
If using Elastic (custom dashboard helper):

**Reference:** `Robot-2025/src/main/java/frc/robot/util/Elastic.java`

Provides custom Shuffleboard tab management and auto-switching.

## PathPlanner Setup for 2026

1. Copy PathPlanner config from AutoBuilder setup in Drive.java
2. Create new paths for 2026 field in PathPlanner GUI
3. Register named commands for game-specific actions
4. Test paths in simulation first

## Testing Checklist Before First Competition

- [ ] Verify all CAN IDs match physical robot
- [ ] Test drive in all modes (normal, smart, etc.)
- [ ] Test all autonomous modes
- [ ] Verify vision alignment on both alliances
- [ ] Check all subsystem limits and safety checks
- [ ] Test emergency stop procedures
- [ ] Verify battery voltage warnings
- [ ] Test all driver controls and button bindings
- [ ] Run full simulation suite
- [ ] Log and replay test matches
- [ ] Tune PID values for new robot
- [ ] Verify spotless formatting passes
- [ ] Set `isCompetition = true` and `tuningMode = false`

## Common Migration Issues

### Issue: CAN IDs Don't Match
**Solution:** Update all Constants files with actual robot CAN IDs. Use REV Hardware Client and Phoenix Tuner to verify.

### Issue: Drive Direction Reversed
**Solution:** Check motor inversions in DriveConstants and ModuleIOSpark. Test each module individually.

### Issue: Vision Estimates Jumping
**Solution:** Adjust standard deviations in VisionConstants. Filter by tag count and ambiguity.

### Issue: Loop Overruns
**Solution:** Check thread priority is set. Monitor via AdvantageKit logs. Optimize heavy operations.

### Issue: Spotless Fails
**Solution:** Run `./gradlew spotlessApply` before committing. Check spotless config in build.gradle.

## Questions to Ask Claude During Development

1. "Create a new [mechanism] subsystem following team 3572's pattern"
2. "Review this code for team 3572's best practices"
3. "Add a preset system to my [subsystem]"
4. "Create alignment strategies for [game task]"
5. "Help me tune PID values for [mechanism]"
6. "Add health monitoring to [subsystem]"
7. "Create autonomous commands for [strategy]"

## Reference Material

- **2025 Robot Analysis:** `.claude/2025-ROBOT-ANALYSIS.md`
- **2025 Code:** `C:\FRC Projects\Robot-2025\`
- **Team Patterns:** Documented in `.claude/settings.json`

Good luck with the 2026 season! 🤖🏆
