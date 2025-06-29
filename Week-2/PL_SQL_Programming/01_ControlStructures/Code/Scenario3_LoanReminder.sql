SET SERVEROUTPUT ON;

BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Loan Reminders for Loans Due in Next 30 Days ---');
    FOR rec IN (
        SELECT l.LoanID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
        ORDER BY l.EndDate
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear ' || rec.Name ||
            ', your LoanID ' || rec.LoanID ||
            ' is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
/
