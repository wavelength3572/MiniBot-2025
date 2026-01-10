# Claude Code Settings for FRC 2026 - Team Wavelength 3572

This directory contains customized Claude Code settings specifically tailored to Team 3572's coding patterns and the 2026 FRC season using AdvantageKit.

**Your 2025 robot code has been analyzed and integrated into these settings!**

## Features

### Team-Specific Custom Instructions ⭐
Claude is configured to follow **Team 3572's exact patterns from 2025**:
- Your 5-file subsystem structure (Subsystem, IO, IOSpark, IOVirtualSim, Constants, Configs)
- REV Spark configuration patterns with URCL logging
- Composite subsystem pattern (like your CoralSystem)
- Strategy pattern for alignment (like your 2025 alignment strategies)
- Thread priority management and odometry threading
- PhotonVision integration with pose estimation
- PathPlanner integration with custom pathfinding
- Health monitoring and Alert patterns
- Lombok usage (@Getter, @AutoLogOutput)
- Your build and deploy workflow

### Aliases
Quick commands available:
- `build` - Compile the robot code
- `deploy` - Deploy code to the robot
- `sim` - Run robot simulation
- `format` - Format code with Spotless
- `clean` - Clean build artifacts

### Hooks
- **pre-commit**: Automatically formats code with Spotless before committing

### Custom Prompts (Team 3572 Specific)
Located in `.claude/prompts/`:
- `new-subsystem.md` - Create subsystems following your exact 2025 pattern
- `new-command.md` - Guide for creating commands
- `review-code.md` - Review against Team 3572's standards and 2025 patterns

### Analysis Documents
- `2025-ROBOT-ANALYSIS.md` - Comprehensive analysis of your 2025 robot code
  - Architecture breakdown
  - Reusable components identified
  - Best practices documented
  - Suggestions for 2026
- `MIGRATION-GUIDE.md` - Step-by-step guide for migrating from 2025 to 2026
  - What to copy directly (drive, vision, utilities)
  - How to adapt patterns for new game
  - Common migration issues and solutions

## Usage

### Using Aliases
In Claude Code, you can use aliases directly:
```
run build
```

### Using Custom Prompts
Reference prompts in your conversations:
```
Follow the new-subsystem prompt to create a drivetrain
```

### Build and Deploy Workflow
1. Make code changes
2. Run `build` to compile and check for errors
3. Run `format` to apply code formatting
4. Run `sim` to test in simulation
5. Run `deploy` when ready to deploy to robot

## Tips for FRC 2026 Season

### Building on 2025 Success
1. **Reuse your swerve drive** - Your 2025 drive code is excellent, just update constants
2. **Copy vision subsystem** - If using PhotonVision again, it's ready to go
3. **Use your utility classes** - Elastic, RobotStatus, and alignment utilities are reusable
4. **Apply composite pattern** - For complex mechanisms (like your CoralSystem)
5. **Use strategy pattern** - For different autonomous behaviors (like your alignment strategies)

### Development Best Practices
1. **Always test in simulation first** before deploying to robot
2. **Use the IO layer** for ALL hardware - you already do this perfectly
3. **Log everything** - Continue your excellent AdvantageKit logging practices
4. **Run format before committing** - pre-commit hook does this automatically
5. **Set up URCL** - Map all new Spark CAN IDs in Robot.java
6. **Add health monitoring** - Alert objects for all hardware
7. **Use thread priorities** - Copy pattern from 2025 Robot.java

### Kickoff Weekend
1. Read the `2025-ROBOT-ANALYSIS.md` for insights from last year
2. Follow the `MIGRATION-GUIDE.md` for copying reusable code
3. Ask Claude: "Analyze the 2026 game and suggest subsystems based on our 2025 patterns"

## Getting Help from Claude

### Team-Specific Questions You Can Ask
- "Create a new [mechanism] subsystem following team 3572's pattern"
- "Review this code against team 3572's 2025 standards"
- "Copy the drive subsystem from 2025 and adapt it for 2026"
- "Create a composite subsystem like our 2025 CoralSystem"
- "Add alignment strategies for [2026 game task]"
- "Set up URCL logging for my new Spark controllers"
- "Create a preset system for my [mechanism]"
- "How did we handle [problem] in 2025?"

### General FRC Questions
- "Implement closed-loop velocity control with AdvantageKit"
- "Add vision pose estimation to the drive subsystem"
- "Create autonomous routines with PathPlanner"
- "Add health monitoring and alerts to my subsystem"

### Reference Material Available
- **Your 2025 code**: `C:\FRC Projects\Robot-2025\`
- **2025 Analysis**: `.claude/2025-ROBOT-ANALYSIS.md`
- **Migration Guide**: `.claude/MIGRATION-GUIDE.md`
- **Team patterns**: Documented in `.claude/settings.json`

## Quick Reference: What's Different from Generic AdvantageKit

Team 3572 uses these specific patterns:
- ✅ **IOSpark** (not IOReal) - for REV Spark controllers
- ✅ **IOVirtualSim** (not IOSim) - for simulation
- ✅ **5 files per subsystem** - includes Configs.java
- ✅ **URCL logging** - for detailed Spark telemetry
- ✅ **Thread priority management** - for consistent loop timing
- ✅ **Lombok** - @Getter and @AutoLogOutput
- ✅ **Composite subsystems** - for complex mechanisms
- ✅ **Strategy pattern** - for autonomous behaviors
- ✅ **SparkOdometryThread** - for swerve drive

Good luck at kickoff tomorrow and throughout the 2026 season! 🤖🏆
