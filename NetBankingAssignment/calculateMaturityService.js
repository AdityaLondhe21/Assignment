function renderCalculateDepositPage() {

    const previousContent = document.querySelector('.content').innerHTML;

    window.renderPreviousContent = function() {
        document.querySelector('.content').innerHTML = previousContent;
    };
    const depositPage = document.createElement('div');
    depositPage.className = 'service-page';
    depositPage.innerHTML = `
        <div style="width: 100%; margin-bottom: 20px;">
            <button style="color: #007bff;border:none;background-color:transparent;" onclick="renderPreviousContent()"> Back </button>
        </div>
        <h1>Calculate Deposit</h1>
        <div class="deposit-form">
            <label for="deposit-amount">Deposit Amount:</label>
            <input type="number" id="deposit-amount" placeholder="Enter deposit amount" />
            <label for="deposit-tenure">Deposit Tenure (years):</label>
            <input type="number" id="deposit-tenure" placeholder="Enter deposit tenure" />
            <button onclick="calculateDeposit()">Calculate</button>
        </div>
        <div id="result"></div>
    `;
    const container = document.querySelector('.content');
    container.innerHTML = '';
    container.appendChild(depositPage);
}
function calculateDeposit() {
    const principal = parseFloat(document.getElementById('deposit-amount').value);
    const tenure = parseFloat(document.getElementById('deposit-tenure').value);

    if (isNaN(principal) || isNaN(tenure) || tenure >= 10) {
        alert('Please enter valid values. Tenure should be less than 10 years.');
        return;
    }

    const interestRate = 0.07;
    const maturityAmount = principal * Math.pow((1 + interestRate), tenure);

    document.getElementById('result').innerText = `Maturity Amount: Rs ${maturityAmount.toFixed(2)}/-`;
}