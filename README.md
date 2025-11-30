# Tax Calculator Assignment (1DV609)

This is Part 2 of Assignment 1. It is a simple program that calculates how much tax a person needs to pay based on their income.

## How the Tax is Calculated

We use a simplified version of the Swedish tax system. Here are the rules:

1. **Low Income (Tax Free)**

   - If you earn less than **20,000 SEK**, you pay **0 SEK** in tax.
2. **Standard Income (Municipal Tax)**

   - If you earn **20,000 SEK or more**, you pay **30% tax** on the amount *above* 20,000 SEK.
   - *Example:* If you earn 25,000 SEK, you only pay tax on the 5,000 SEK that is above the limit.
3. **High Income (State Tax)**

   - If you earn more than **600,000 SEK**, you pay an **extra 20% tax** on the amount *above* 600,000 SEK.
   - This is on top of the standard municipal tax.

## Technologies Used

- **Language:** Java
- **Testing:** JUnit 5 (for checking that the code works correctly)
- **Code Coverage:** JaCoCo (to see how much of the code is tested)

## Project Structure

- `src/Main`: Contains the main code (Model and Controller and View).
- `src/Tests`: Contains the automated tests.
