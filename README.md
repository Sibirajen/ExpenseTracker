# ExpTrackerCLI - Command-Line Expense Tracker

This project is a challenge from [Expense Tracker](https://roadmap.sh/projects/expense-tracker)

ExpTrackerCLI is a simple command-line application for tracking expenses. Users can add, delete, list, and summarize expenses efficiently from the terminal.

## Features

- Add a new expense with a description and amount.
- Delete an expense by ID.
- List all recorded expenses.
- View a summary of expenses for a specific month.

## Usage

### General Syntax

```bash
  ExpTrackerCLI <command> [arguments]
```

### Available Commands

| Command                  | Description                                    | Example                               |
|--------------------------|------------------------------------------------|---------------------------------------|
| `add -d <desc> -a <amt>` | Add a new expense with description and amount. | `ExpTrackerCLI add -d "Lunch" -a 250` |
| `delete -i <id>`         | Delete an expense by ID.                       | `ExpTrackerCLI delete -i 1`           |
| `list`                   | List all expenses.                             | `ExpTrackerCLI list`                  |
| `summary`                | View a summary of all expenses.                | `ExpTrackerCLI summary`               |
| `summary -m <month>`     | View a summary for a specific month.           | `ExpTrackerCLI summary -m 2`          |

### Help Command

If you enter an invalid command or need assistance, ExpTrackerCLI will display a help message with all available commands.