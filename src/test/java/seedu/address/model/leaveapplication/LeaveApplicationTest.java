package seedu.address.model.leaveapplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DESCRIPTION_BOB_LEAVE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LEAVEDATE_BOB_LEAVE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LEAVEID_BOB_LEAVE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_LEAVESTATUS_BOB_LEAVE;
import static seedu.address.testutil.TypicalLeaveApplications.ALICE_LEAVE;
import static seedu.address.testutil.TypicalLeaveApplications.BENSON_LEAVE;

import java.time.LocalDateTime;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import seedu.address.testutil.LeaveApplicationBuilder;

public class LeaveApplicationTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        LeaveApplication leaveApplication = new LeaveApplicationBuilder().build();
        thrown.expect(UnsupportedOperationException.class);
        leaveApplication.getDates().remove(0);
    }

    @Test
    public void equals() {
        // same values -> returns true
        LeaveApplication aliceCopy = new LeaveApplicationBuilder(ALICE_LEAVE).build();
        assertTrue(ALICE_LEAVE.equals(aliceCopy));

        // same object -> returns true
        assertTrue(ALICE_LEAVE.equals(ALICE_LEAVE));

        // null -> returns false
        assertFalse(ALICE_LEAVE.equals(null));

        // different type -> returns false
        assertFalse(ALICE_LEAVE.equals(5));

        // different leave application -> returns false
        assertFalse(ALICE_LEAVE.equals(BENSON_LEAVE));

        // different id -> returns false
        LeaveApplication editedAlice = new LeaveApplicationBuilder(ALICE_LEAVE)
                .withId(VALID_LEAVEID_BOB_LEAVE).build();
        assertFalse(ALICE_LEAVE.equals(editedAlice));

        // different description -> returns false
        editedAlice = new LeaveApplicationBuilder(ALICE_LEAVE).withDescription(VALID_DESCRIPTION_BOB_LEAVE).build();
        assertFalse(ALICE_LEAVE.equals(editedAlice));

        // different status -> returns false
        editedAlice = new LeaveApplicationBuilder(ALICE_LEAVE).withStatus(VALID_LEAVESTATUS_BOB_LEAVE).build();
        assertFalse(ALICE_LEAVE.equals(editedAlice));

        // different dates -> returns false
        editedAlice = new LeaveApplicationBuilder(ALICE_LEAVE).withDates(VALID_LEAVEDATE_BOB_LEAVE).build();
        assertFalse(ALICE_LEAVE.equals(editedAlice));
    }

    @Test
    public void toStringTest() {
        // same expected and actual toString() output for TypicalPerson's ALICE
        StringBuilder builder = new StringBuilder();
        builder.append(0)
                .append(" Description: ")
                .append("Alice family holiday")
                .append(" Status: ")
                .append(StatusEnum.Status.PENDING.toString())
                .append(" Dates: ")
                .append(LocalDateTime.of(2018, 10, 23, 0, 0, 0).toString())
                .append(LocalDateTime.of(2018, 10, 24, 0, 0, 0).toString());
        assertEquals(ALICE_LEAVE.toString(), builder.toString());

        // same expected and actual toString() output for TypicalPerson's BENSON
        builder = new StringBuilder();
        builder.append(0)
                .append(" Description: ")
                .append("Benson's brother's wedding")
                .append(" Status: ")
                .append(StatusEnum.Status.APPROVED.toString())
                .append(" Dates: ")
                .append(LocalDateTime.of(2018, 10, 25, 0, 0, 0).toString())
                .append(LocalDateTime.of(2018, 10, 26, 0, 0, 0).toString());
        assertEquals(BENSON_LEAVE.toString(), builder.toString());
    }
}