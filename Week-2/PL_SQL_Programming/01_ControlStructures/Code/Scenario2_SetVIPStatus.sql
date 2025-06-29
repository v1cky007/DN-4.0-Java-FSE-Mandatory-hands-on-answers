SET SERVEROUTPUT ON;

BEGIN
    FOR rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('--- Customers After VIP Promotion (Balance > 10,000) ---');
    FOR rec IN (
        SELECT CustomerID, Name, Balance, IsVIP
        FROM Customers
        ORDER BY CustomerID
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'CustomerID: ' || rec.CustomerID ||
            ', Name: ' || rec.Name ||
            ', Balance: ' || rec.Balance ||
            ', IsVIP: ' || NVL(rec.IsVIP, 'N')
        );
    END LOOP;
END;
/
