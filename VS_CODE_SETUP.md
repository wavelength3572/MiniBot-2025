# VS Code Setup Guide for FRC Robotics

This guide will help you set up Visual Studio Code for an efficient robotics development workflow.

## 📦 Required Extensions

When you open this project, VS Code will prompt you to install recommended extensions. Click "Install All" or install them manually:

### Essential Extensions
- **WPILib** - Official FRC development tools
- **Extension Pack for Java** - Java language support
- **Gradle for Java** - Build automation
- **Spotless Gradle** - Code formatting

### Productivity Extensions
- **GitLens** - Enhanced Git integration and history
- **Error Lens** - Inline error highlighting (super helpful!)
- **Live Share** - Real-time collaboration with teammates
- **Markdown Preview Enhanced** - Better documentation viewing

### Optional but Helpful
- **GitHub Copilot** - AI-powered code suggestions (requires subscription)
- **Indent Rainbow** - Color-coded indentation
- **Code Spell Checker** - Catch typos in your code

## ⚙️ Key Settings Configured

This project has several helpful settings pre-configured:

- **Auto-save** - Your work saves automatically every 5 seconds
- **Format on Save** - Code automatically formats when you save
- **Error Lens** - Errors and warnings appear inline (no need to hover)
- **GitLens** - See who wrote each line of code and when

## 🎯 Code Snippets

Type these prefixes and press Tab to generate common FRC code patterns:

- `frc-command` - New Command class template
- `frc-subsystem` - New Subsystem with AdvantageKit logging
- `frc-io` - AdvantageKit IO interface
- `frc-pid` - PID controller setup
- `frc-trigger` - Button trigger binding
- `frc-auto` - Autonomous command
- `frc-path` - PathPlanner path loading
- `log` - Quick Logger.recordOutput()

### Example Usage:
1. Type `frc-command`
2. Press Tab
3. Fill in the command name
4. Tab through the template to fill in details

## 🛠️ VS Code Tasks

Access these tasks via:
- **Terminal → Run Task** menu
- **Ctrl+Shift+B** for build tasks
- **Ctrl+Shift+P** → "Tasks: Run Task"

### Available Tasks:
- **Build Robot Code** (Ctrl+Shift+B) - Compile the robot project
- **Deploy to Robot** - Build and deploy to the roboRIO
- **Simulate Robot** - Run robot code in desktop simulation
- **Format Code (Spotless)** - Auto-format all code
- **Check Code Format** - Verify code formatting
- **Run Unit Tests** - Execute test suite
- **Clean Build** - Clear build cache and rebuild

## 🐛 Debugging

### Desktop Simulation Debug:
1. Press **F5** or click Run → Start Debugging
2. Select "WPILib Desktop Debug"
3. Set breakpoints by clicking left of line numbers
4. Use debug toolbar to step through code

### roboRIO Debug:
1. Connect to robot network
2. Press **F5** and select "WPILib roboRIO Debug"
3. Wait for deployment to complete
4. Debug remotely on the robot

## 💡 Keyboard Shortcuts to Know

### General:
- `Ctrl+Shift+P` - Command Palette (access all commands)
- `Ctrl+P` - Quick file search
- `Ctrl+Shift+F` - Search in all files
- `Ctrl+B` - Toggle sidebar
- `Ctrl+J` - Toggle terminal

### Coding:
- `Ctrl+Space` - Trigger IntelliSense
- `Ctrl+.` - Quick fixes and refactoring
- `F2` - Rename symbol
- `Alt+Up/Down` - Move line up/down
- `Ctrl+/` - Toggle line comment
- `Ctrl+Shift+/` - Toggle block comment

### Navigation:
- `F12` - Go to definition
- `Shift+F12` - Find all references
- `Ctrl+Click` - Go to definition
- `Alt+Left/Right` - Navigate back/forward

### Multi-cursor:
- `Alt+Click` - Add cursor
- `Ctrl+Alt+Up/Down` - Add cursor above/below
- `Ctrl+D` - Select next occurrence of word

## 📚 WPILib Commands

Access WPILib tools via Command Palette (`Ctrl+Shift+P`):

- **WPILib: Deploy Robot Code** - Build and deploy
- **WPILib: Simulate Robot Code** - Run in simulation
- **WPILib: Set Team Number** - Configure team number
- **WPILib: Manage Vendor Libraries** - Update dependencies
- **WPILib: Create New Class** - Generate new Java class
- **WPILib: Change Desktop Support Enabled** - Toggle simulation support

## 🤝 Collaboration Tips

### Using Live Share:
1. Install "Live Share" extension
2. Click "Live Share" in status bar
3. Share link with teammate
4. They can edit code in real-time with you

### Git Best Practices:
1. **Pull before you start** - `git pull` to get latest changes
2. **Commit often** - Small, focused commits
3. **Write good messages** - "Add elevator subsystem" not "stuff"
4. **Push when done** - Share your work with the team

### Git in VS Code:
- Source Control panel (Ctrl+Shift+G)
- Stage changes by clicking "+"
- Write commit message
- Click checkmark to commit
- Click "..." → Push to upload

## 🔥 Common Issues & Solutions

### "Java extension not working"
- Reload window: `Ctrl+Shift+P` → "Developer: Reload Window"
- Clean Java workspace: `Ctrl+Shift+P` → "Java: Clean Java Language Server Workspace"

### "Build failed"
- Run "Clean Build" task
- Check terminal for error messages
- Make sure all vendor dependencies are installed

### "Can't deploy to robot"
- Verify you're on robot network (10.TE.AM.2)
- Check roboRIO is powered on
- Ping roboRIO: `ping roborio-TEAM-frc.local`

### "Format on save not working"
- Make sure Spotless Gradle extension is installed
- Run "Format Code (Spotless)" task manually

## 📖 Learning Resources

- [WPILib Documentation](https://docs.wpilib.org/)
- [Chief Delphi Forums](https://www.chiefdelphi.com/)
- [AdvantageKit Docs](https://github.com/Mechanical-Advantage/AdvantageKit)
- [PathPlanner Documentation](https://pathplanner.dev/)
- [Java Programming Guide](https://docs.wpilib.org/en/stable/docs/software/java-basics/index.html)

## 🎓 For Mentors

### Teaching Tips:
1. **Use Live Share** for pairing with students remotely
2. **Enable GitLens blame** to track who wrote what
3. **Use terminal split view** to show multiple outputs
4. **Leverage snippets** to teach code patterns
5. **Use tasks** instead of manual gradle commands

### Student Onboarding Checklist:
- [ ] Install WPILib suite
- [ ] Install recommended VS Code extensions
- [ ] Configure Git user name and email
- [ ] Practice using code snippets
- [ ] Complete first build and deploy
- [ ] Run simulation successfully
- [ ] Make first commit and push

### Code Review in VS Code:
1. Use GitLens to see code history
2. Review diffs in Source Control panel
3. Add comments in code with `// TODO:` for students
4. Use Live Share to review together in real-time

## 🚀 Quick Start Checklist

- [ ] Open this folder in VS Code
- [ ] Install all recommended extensions
- [ ] Press Ctrl+Shift+B to build
- [ ] Try a code snippet (type `frc-command` + Tab)
- [ ] Run "Simulate Robot" task
- [ ] Set a breakpoint and press F5 to debug

## 📝 Notes

- Settings are in `.vscode/settings.json`
- Tasks are in `.vscode/tasks.json`
- Snippets are in `.vscode/java.json`
- All settings are shared with the team via Git

---

**Need help?** Ask a mentor or check the WPILib documentation!
