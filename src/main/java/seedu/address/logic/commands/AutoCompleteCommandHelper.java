package seedu.address.logic.commands;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Helper class to auto complete commands typed into command box
 */
public class AutoCompleteCommandHelper {
    private static String[] commandWordList = {
        AddCommand.COMMAND_WORD,
        ClearCommand.COMMAND_WORD,
        DeleteCommand.COMMAND_WORD,
        EditCommand.COMMAND_WORD,
        ExitCommand.COMMAND_WORD,
        FindCommand.COMMAND_WORD,
        HelpCommand.COMMAND_WORD,
        HistoryCommand.COMMAND_WORD,
        ListCommand.COMMAND_WORD,
        RedoCommand.COMMAND_WORD,
        SelectCommand.COMMAND_WORD,
        UndoCommand.COMMAND_WORD,
        ModifyPermissionCommand.COMMAND_WORD,
        ViewPermissionCommand.COMMAND_WORD
    };

    /**
     * This method predicts the command the user is entering.
     *
     * @param partialWord The current characters available in command box.
     * @return The predicted command.
     */
    public static Set<String> autoCompleteWord(String partialWord) {
        if (partialWord == null || partialWord.equals("")) {
            return new HashSet<>();
        }

        if (partialWord.equals(" ")) {
            return new HashSet<>(Arrays.asList(commandWordList));
        }

        Set<String> suggestions = new HashSet<>();
        for (String s : commandWordList) {
            if (s.startsWith(partialWord)) {
                suggestions.add(s);
            }
        }
        return suggestions;
    }
}
