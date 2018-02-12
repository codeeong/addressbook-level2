package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.*;

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": sorts all the people in address book by alphabetical order.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = new ArrayList<>(addressBook.getAllPersons().immutableListView());
        Collections.sort(allPersons,new SortByName());
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}

class SortByName implements Comparator<ReadOnlyPerson>  {
    public int compare(ReadOnlyPerson a, ReadOnlyPerson b) {
        return a.getName().toString().compareTo(b.getName().toString());
    }
}
