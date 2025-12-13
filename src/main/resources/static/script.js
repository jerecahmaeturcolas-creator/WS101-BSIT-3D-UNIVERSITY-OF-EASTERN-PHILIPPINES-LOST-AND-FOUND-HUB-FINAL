// src/main/resources/static/js/script.js

document.addEventListener('DOMContentLoaded', function() {
    // Initialize search functionality
    const searchInput = document.querySelector('input[placeholder*="Search"]');
    const searchButton = document.querySelector('.btn-primary[type="button"]');

    if (searchInput && searchButton) {
        searchButton.addEventListener('click', performSearch);
        searchInput.addEventListener('keypress', function(e) {
            if (e.key === 'Enter') performSearch();
        });
    }

    // Initialize statistics animation
    animateStatistics();
});

function performSearch() {
    const searchInput = document.querySelector('input[placeholder*="Search"]');
    const query = searchInput.value.trim();

    if (query) {
        alert(`Searching for: "${query}"\n\nThis would redirect to search results in a real application.`);
        // In real app: window.location.href = `/search?q=${encodeURIComponent(query)}`;
    } else {
        searchInput.focus();
    }
}

function animateStatistics() {
    const counters = document.querySelectorAll('.badge');

    counters.forEach(counter => {
        const target = parseInt(counter.textContent.replace('%', '').replace(',', ''));
        if (!isNaN(target)) {
            let current = 0;
            const increment = target / 50;

            const updateCounter = () => {
                if (current < target) {
                    current += increment;
                    counter.textContent = Math.round(current) + (counter.textContent.includes('%') ? '%' : '');
                    setTimeout(updateCounter, 30);
                } else {
                    counter.textContent = target + (counter.textContent.includes('%') ? '%' : '');
                }
            };

            updateCounter();
        }
    });
}