document.addEventListener("DOMContentLoaded", () => {
    // Rating labels map
    const ratingLabels = {
        1: "1★ - Rất không hài lòng 😡",
        2: "2★ - Chưa hài lòng 🙁",
        3: "3★ - Bình thường 😐",
        4: "4★ - Hài lòng 🙂",
        5: "5★ - Rất hài lòng 🤩"
    };

    const stars = document.querySelectorAll(".star");
    const ratingInput = document.getElementById("overallRatingInput");
    const ratingDisplay = document.getElementById("ratingDisplay");

    if (stars.length && ratingInput && ratingDisplay) {
        function updateStars(rating) {
            stars.forEach((star) => {
                const starVal = parseInt(star.getAttribute("data-val"), 10);
                if (starVal <= rating) {
                    star.classList.add("active");
                } else {
                    star.classList.remove("active");
                }
            });
            ratingDisplay.textContent = ratingLabels[rating] || (rating + "★");
        }

        // Initialize display
        const initialRating = parseInt(ratingInput.value, 10) || 5;
        updateStars(initialRating);

        // Click handler
        stars.forEach((star) => {
            star.addEventListener("click", () => {
                const val = parseInt(star.getAttribute("data-val"), 10);
                ratingInput.value = val;
                updateStars(val);
            });

            // Hover preview
            star.addEventListener("mouseenter", () => {
                const val = parseInt(star.getAttribute("data-val"), 10);
                updateStars(val);
            });
        });

        // Reset to current selected value when mouse leaves
        const starsContainer = document.querySelector(".stars-container");
        if (starsContainer) {
            starsContainer.addEventListener("mouseleave", () => {
                const currentVal = parseInt(ratingInput.value, 10) || 5;
                updateStars(currentVal);
            });
        }
    }
});
