// Mobile nav toggle
document.addEventListener('DOMContentLoaded', () => {
  const toggle = document.querySelector('.nav-toggle');
  const nav = document.querySelector('.primary-nav');
  if (toggle && nav) {
    toggle.addEventListener('click', () => {
      const isOpen = nav.classList.toggle('open');
      toggle.setAttribute('aria-expanded', isOpen);
    });
  }

  // Live date in status strip
  const dateEl = document.getElementById('today-date');
  if (dateEl) {
    const now = new Date();
    const options = { weekday: 'short', year: 'numeric', month: 'short', day: 'numeric' };
    dateEl.textContent = now.toLocaleDateString('en-US', options);
  }

  // Simple health check ping (placeholder for real monitoring integration)
  const healthEl = document.getElementById('health-status');
  if (healthEl) {
    // In production this could poll an actual health endpoint
    healthEl.textContent = 'ALL SYSTEMS NORMAL';
  }
});
