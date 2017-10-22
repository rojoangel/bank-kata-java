Feature: Bank Account

  Scenario: Statement Printing
    Given a client deposits 1000 on 01/04/2014
      And withdraws 100 on 02/04/2014
      And deposits 500 on 10/04/2014
     When he prints his bank statement
     Then he sees
        | DATE       \| AMOUNT  \| BALANCE |
     	| 10/04/2014 \| 500.00  \| 1400.00 |
     	| 02/04/2014 \| -100.00 \| 900.00  |
     	| 01/04/2014 \| 1000.00 \| 1000.00 |
