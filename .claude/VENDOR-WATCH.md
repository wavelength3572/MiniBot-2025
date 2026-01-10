# Vendor Library Release Monitoring - 2026 Season

## Current Status (as of 2025 season)

Your 2025 versions:
- ✅ **REVLib**: 2025.0.3
- ✅ **Phoenix 6 (CTRE)**: 25.3.2
- ✅ **PathPlanner**: 2025.2.6
- ✅ **WPILib**: 2025.3.2
- ✅ **PhotonVision**: (check in vendordeps)
- ✅ **AdvantageKit**: (check in vendordeps)
- ✅ **URCL**: (check in vendordeps)

## 2026 Release Timeline (Estimated)

### Early January (Post-Kickoff)
WPILib typically releases the 2026 version 1-2 weeks after kickoff (January 4, 2026).

### Mid-January
Vendors usually release 2026-compatible versions 2-4 weeks after kickoff:
- REVLib (1-2 weeks after WPILib)
- Phoenix 6 (1-2 weeks after WPILib)
- PathPlanner (usually quick to update)
- PhotonVision (typically ready early)
- AdvantageKit (watch for 2026 template announcement)

### What to Watch For
The key milestone is: **AdvantageKit 2026 Swerve Template Release**
This signals all major vendor libraries are ready.

## Monitoring Methods

### Method 1: GitHub Watch (Recommended)
Set up email notifications for releases:

1. **REVLib**: https://github.com/REVrobotics/REVLib
   - Click "Watch" → "Custom" → Check "Releases"

2. **Phoenix 6**: https://github.com/CrossTheRoadElec/Phoenix6-releases
   - Click "Watch" → "Custom" → Check "Releases"

3. **PathPlanner**: https://github.com/mjansen4857/pathplanner
   - Click "Watch" → "Custom" → Check "Releases"

4. **PhotonVision**: https://github.com/PhotonVision/photonvision
   - Click "Watch" → "Custom" → Check "Releases"

5. **AdvantageKit**: https://github.com/Mechanical-Advantage/AdvantageKit
   - Click "Watch" → "Custom" → Check "Releases"
   - **IMPORTANT**: Watch for "2026 Swerve Template" announcement

### Method 2: Check JSON URLs (Quick Version Check)
These URLs always point to latest version:

```bash
# REVLib latest
curl https://software-metadata.revrobotics.com/REVLib-2026.json

# Phoenix 6 latest
curl https://maven.ctr-electronics.com/release/com/ctre/phoenix6/latest/Phoenix6-frc2026-latest.json

# PathPlanner latest
curl https://3015rangerrobotics.github.io/pathplannerlib/PathplannerLib.json
```

### Method 3: Chief Delphi Monitoring
**Most reliable for FRC community:**
- Bookmark: https://www.chiefdelphi.com/c/technical/programming/
- Check daily during January
- Vendors announce releases here first
- Enable email notifications for the Programming category

### Method 4: Discord Monitoring
**Official FRC Discord** (fastest updates):
- Join: https://discord.gg/frc
- Watch these channels:
  - #programming
  - #wpilib
  - #third-party-libraries
- Vendors often announce here before official releases

## Quick Check Command

Run this to see if 2026 versions exist:

```bash
# In your project directory
./gradlew dependencies --configuration runtimeClasspath | grep -E "(REV|ctre|pathplanner)"
```

## When Libraries Are Ready

### Checklist:
- [ ] WPILib 2026 released
- [ ] REVLib 2026.x.x available
- [ ] Phoenix 6 26.x.x available
- [ ] PathPlanner 2026.x.x available
- [ ] PhotonVision 2026 compatible
- [ ] AdvantageKit 2026 template released ⭐

### Then:
1. **Read release notes** for breaking changes
2. **Compare template** to your 2025 code (ask Claude!)
3. **Decide**: Update 2025 code OR start from template
4. **Update vendordeps** in chosen project
5. **Test in simulation** before deploying

## Specific Vendor Pages

### REV Robotics
- **Docs**: https://docs.revrobotics.com/
- **Software**: https://docs.revrobotics.com/rev-hardware-client/
- **Maven**: https://maven.revrobotics.com/
- **Support**: support@revrobotics.com

### CTRE (Phoenix 6)
- **Docs**: https://v6.docs.ctr-electronics.com/
- **Download**: https://pro.docs.ctr-electronics.com/en/latest/docs/installation/installation-frc.html
- **Maven**: https://maven.ctr-electronics.com/
- **Support**: https://store.ctr-electronics.com/support/

### PathPlanner
- **Docs**: https://pathplanner.dev/
- **GUI Download**: https://github.com/mjansen4857/pathplanner/releases
- **Support**: Chief Delphi or GitHub Issues

### PhotonVision
- **Docs**: https://docs.photonvision.org/
- **Download**: https://photonvision.org/download
- **Discord**: https://discord.gg/wZyZEP4

### AdvantageKit
- **Docs**: https://docs.advantagekit.org/
- **Templates**: https://github.com/Mechanical-Advantage/AdvantageKit/releases
- **Discord**: Ask in their Discord or Chief Delphi

## Red Flags (Don't Start Yet!)

❌ WPILib 2026 not released yet
❌ REVLib still shows 2025.x.x as latest
❌ Phoenix still shows 25.x.x as latest
❌ AdvantageKit hasn't announced 2026 template
❌ Chief Delphi shows vendors still testing 2026

## Green Lights (Ready to Go!)

✅ WPILib 2026.1.0+ released
✅ REVLib 2026.x.x available
✅ Phoenix 6 26.x.x available
✅ PathPlanner 2026.x.x available
✅ AdvantageKit 2026 template announced
✅ Chief Delphi reports successful testing

## Expected Timeline Summary

| Date | Milestone |
|------|-----------|
| Jan 4, 2026 | Kickoff + Game Release |
| Jan 8-15, 2026 | WPILib 2026 release (likely) |
| Jan 15-22, 2026 | Vendor libraries start releasing |
| Jan 22-29, 2026 | AdvantageKit template likely ready |
| Early Feb 2026 | All libraries stable |

**Recommendation:** Start monitoring January 8, 2026. Don't rush - let early adopters find bugs first!

## Your Action Items

### This Week (Pre-Kickoff):
- [x] Analyze 2025 code (done!)
- [x] Set up Claude configuration (done!)
- [ ] GitHub Watch on all vendor repos
- [ ] Join FRC Discord programming channels
- [ ] Bookmark Chief Delphi programming forum

### Kickoff Weekend (Jan 4-6):
- [ ] Check for WPILib 2026 announcement
- [ ] Start designing 2026 robot subsystems
- [ ] Plan what to reuse from 2025

### Week of Jan 8-15:
- [ ] Check daily for vendor library releases
- [ ] Read release notes when available
- [ ] Wait for AdvantageKit template

### Week of Jan 15-22:
- [ ] AdvantageKit template hopefully released
- [ ] Compare template to your 2025 code
- [ ] Make decision: update vs. restart
- [ ] Begin 2026 code development

### Week of Jan 22-29:
- [ ] Update to 2026 libraries
- [ ] Port reusable code
- [ ] Test in simulation
- [ ] Begin integration with robot

---

**Bottom Line:** You'll know libraries are ready when AdvantageKit announces their 2026 swerve template. That's your green light! 🟢

Until then, keep working in your 2025 codebase - it's already excellent.
