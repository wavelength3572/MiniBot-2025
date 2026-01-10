# Review FRC Code (Team 3572 Standards)

Review the code against Team 3572's 2025 patterns and FRC best practices:

## 1. Team 3572 Architecture Compliance ⭐
- [ ] Subsystem structure matches team pattern (5 files per subsystem)
- [ ] IO interface has @AutoLog on nested Inputs class
- [ ] Real implementation is IOSpark (not IOReal)
- [ ] Sim implementation is IOVirtualSim or IOSim
- [ ] Constants file exists with CAN IDs, PID values, limits
- [ ] Configs file exists for Spark motor configuration
- [ ] Using Lombok @Getter appropriately
- [ ] Using @AutoLogOutput for calculated values

## 2. AdvantageKit Compliance
- [ ] All hardware interactions through IO layers
- [ ] All sensor readings in AutoLogged Inputs
- [ ] No direct hardware access in main subsystem
- [ ] Proper logging of all inputs and outputs
- [ ] IO implementations handle REAL/SIM/REPLAY correctly

## 3. REV Spark Best Practices
- [ ] Spark configuration in one block before enabling
- [ ] Using SparkBase.configure() pattern with closures
- [ ] Motor inversions set correctly
- [ ] Current limits configured
- [ ] URCL logging set up in Robot.java
- [ ] Using Spark onboard PID when possible
- [ ] MAXMotion for elevators if applicable

## 4. FRC Best Practices
- [ ] Thread priority set in robotPeriodic() (see 2025 Robot.java)
- [ ] Proper units usage (meters, radians, seconds - SI units)
- [ ] Safety checks (limit switches, soft limits)
- [ ] Alert objects for hardware disconnects
- [ ] No blocking operations in periodic methods
- [ ] Resource management (close() methods if needed)

## 5. Command-Based Patterns
- [ ] Proper subsystem requirements declared
- [ ] Correct command lifecycle (initialize, execute, end, isFinished)
- [ ] Appropriate use of triggers and bindings
- [ ] Commands in separate classes (not inline)
- [ ] Named commands registered for PathPlanner if needed

## 6. Vision Integration (if applicable)
- [ ] Validity checks before using vision estimates
- [ ] Filter by tag count and ambiguity
- [ ] Appropriate standard deviations
- [ ] Can toggle vision on/off
- [ ] Integrated with SwerveDrivePoseEstimator

## 7. PathPlanner Integration (if applicable)
- [ ] AutoBuilder configured correctly
- [ ] Named commands registered
- [ ] PID constants tuned
- [ ] Paths tested in simulation

## 8. Alliance Awareness
- [ ] Coordinates account for field flipping
- [ ] Using AllianceFlipUtil or equivalent
- [ ] Tested on both alliances

## 9. Code Quality
- [ ] Clear variable and method names
- [ ] Proper access modifiers (private/public)
- [ ] Constants instead of magic numbers
- [ ] No commented-out code
- [ ] Spotless formatting applied
- [ ] Lombok used appropriately (not overused)

## 10. Performance
- [ ] No loop overruns
- [ ] Thread priorities set correctly
- [ ] Efficient logging (not too verbose)
- [ ] Odometry threading for swerve if applicable

## 11. Safety & Competition Readiness
- [ ] CAN IDs match physical robot
- [ ] isCompetition flag set correctly
- [ ] tuningMode disabled for competition
- [ ] All autonomous modes tested
- [ ] Emergency stop tested
- [ ] Battery voltage warnings configured

## 12. Documentation
- [ ] Complex algorithms commented
- [ ] Preset values explained
- [ ] Alignment math documented
- [ ] Known issues noted

## Compare Against 2025 Code
Check these reference implementations:
- Drive: `Robot-2025/subsystems/drive/`
- Vision: `Robot-2025/subsystems/vision/`
- Composite subsystem: `Robot-2025/subsystems/coral/CoralSystem.java`
- Strategy pattern: `Robot-2025/alignment/`

## Common Issues to Flag
❌ IO layer bypassed (direct hardware in subsystem)
❌ Constants hardcoded in code
❌ Missing simulation implementation
❌ Not using team's file structure
❌ Spark not configured properly
❌ No hardware disconnect alerts
❌ Thread priorities not set
❌ Magic numbers instead of constants
❌ Blocking operations in periodic()
❌ Missing URCL setup for new Sparks
