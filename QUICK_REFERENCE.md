# FRC VS Code Quick Reference Card

## 🔑 Custom Keyboard Shortcuts
| Shortcut | Action |
|----------|--------|
| `Ctrl+Shift+D` | Deploy to Robot |
| `Ctrl+Shift+S` | Simulate Robot |
| `Ctrl+Shift+T` | Run Unit Tests |
| `Ctrl+Alt+F` | Format All Code |
| `Ctrl+Shift+B` | Build Robot Code |
| `F5` | Start Debugging |

## ⚡ Code Snippets (type + Tab)
| Snippet | Description |
|---------|-------------|
| `frc-command` | New Command class |
| `frc-subsystem` | New Subsystem with logging |
| `frc-io` | IO interface |
| `frc-pid` | PID controller |
| `frc-trigger` | Button binding |
| `frc-auto` | Auto command |
| `log` | Logger output |

## 🛠️ Essential VS Code Shortcuts
| Shortcut | Action |
|----------|--------|
| `Ctrl+P` | Quick file search |
| `Ctrl+Shift+P` | Command palette |
| `Ctrl+Shift+F` | Search in files |
| `Ctrl+.` | Quick fix/refactor |
| `F12` | Go to definition |
| `Shift+F12` | Find references |
| `F2` | Rename symbol |
| `Ctrl+/` | Toggle comment |

## 📁 Important Files
- `RobotContainer.java` - Button bindings and subsystem initialization
- `Robot.java` - Main robot class
- `Constants.java` - Robot configuration
- `subsystems/` - Hardware subsystems
- `commands/` - Robot commands

## 🔧 Common WPILib Commands (Ctrl+Shift+P)
- WPILib: Deploy Robot Code
- WPILib: Simulate Robot Code
- WPILib: Set Team Number
- WPILib: Manage Vendor Libraries
- WPILib: Create New Class

## 🐛 Debugging Steps
1. Set breakpoint (click left of line number)
2. Press F5
3. Select "Desktop Debug" or "roboRIO Debug"
4. Use toolbar: Continue, Step Over, Step Into, Step Out

## 📊 AdvantageKit Logging
```java
// In periodic():
Logger.recordOutput("key", value);

// In IO interface:
@AutoLog
public static class Inputs {
  public double position = 0.0;
}
```

## 🔄 Git Workflow
```bash
git pull                    # Get latest changes
git add .                   # Stage all changes
git commit -m "message"     # Commit changes
git push                    # Push to remote
```

## 🚨 Quick Fixes
| Problem | Solution |
|---------|----------|
| Build errors | Run "Clean Build" task |
| Can't deploy | Check robot network, ping roboRIO |
| Java errors | Reload window (Ctrl+Shift+P → Reload) |
| Format issues | Run "Format Code" task |

## 📡 Robot Network
- roboRIO IP: `10.TE.AM.2`
- Radio IP: `10.TE.AM.1`
- Driver Station: `10.TE.AM.5`

---
💡 **Tip:** Keep this guide open in a second editor pane for quick reference!
