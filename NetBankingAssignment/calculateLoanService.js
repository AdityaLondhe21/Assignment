function renderCalculateLoanPage() {

    const previousContent = document.querySelector('.content').innerHTML;

    window.renderPreviousContent = function() {
        document.querySelector('.content').innerHTML = previousContent;
    };

    const loanPage = document.createElement('div');
    loanPage.className = 'service-page';
    loanPage.innerHTML = `
        <div style="width: 100%; margin-bottom: 20px;">
            <button style="color: #007bff;border:none;background-color:transparent;" onclick="renderPreviousContent()"> Back </button>
        </div>
        <h1>Calculate Loan</h1>
        <div class="loan-form">
            <label for="applicant-name">Applicant Name:</label>
            <input type="text" id="applicant-name" placeholder="Enter applicant name" />
            <label for="loan-type">Loan Type:</label>
            <select id="loan-type">
                <option value="home">Home Loan</option>
                <option value="car">Car Loan</option>
                <option value="personal">Personal Loan</option>
            </select>
            <label for="loan-tenure">Loan Tenure (years):</label>
            <input type="number" id="loan-tenure" placeholder="Enter loan tenure (years)" />
            <label for="loan-amount">Loan Amount:</label>
            <input type="number" id="loan-amount" placeholder="Enter loan amount" />
            <button onclick="calculateLoan()">Calculate</button>
        </div>
        <div id="result"></div>
    `;
    const container = document.querySelector('.content');
    container.innerHTML = '';
    container.appendChild(loanPage);
}

function calculateLoan() {
    const loanAmount = document.getElementById('loan-amount').value;
    const loanType = document.getElementById('loan-type').value;
    const loanTenure = document.getElementById('loan-tenure').value;
    const loanInterest = loanType === 'home' ? 9 : loanType === 'car' ? 11 : 15;

    if ((loanType === 'home' && loanTenure > 30) || 
        (loanType === 'car' && loanTenure > 7) || 
        (loanType === 'personal' && loanTenure > 5)) {
        alert('Loan tenure exceeds the maximum allowed for the selected loan type');
        return;
    }
    if ((loanType === 'home' && (loanAmount < 500000 || loanAmount > 10000000)) || 
        (loanType === 'car' && (loanAmount < 100000 || loanAmount > 1500000)) || 
        (loanType === 'personal' && (loanAmount < 10000 || loanAmount > 500000))) {
        alert('Loan amount is out of the allowed range for the selected loan type');
        return;
    }
    if (!loanAmount || !loanTenure || !loanInterest) {
        alert('Please fill all the fields');
        return;
    }
    
    const interestRate = parseFloat(loanInterest) / 100;
    const tenureInMonths = parseInt(loanTenure) * 12;
    const monthlyInterestRate = interestRate / 12;

    const emi = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenureInMonths)) / (Math.pow(1 + monthlyInterestRate, tenureInMonths) - 1);
    const totalPayment = emi * tenureInMonths;
    const totalInterest = totalPayment - loanAmount;

    document.getElementById('result').innerHTML = `
        <p>Monthly EMI: Rs${emi.toFixed(2)}</p>
        <p>Total Payment: Rs${totalPayment.toFixed(2)}</p>
        <p>Total Interest: Rs${totalInterest.toFixed(2)}</p>
    `;
}
