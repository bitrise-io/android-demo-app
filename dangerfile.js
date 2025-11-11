import { danger, warn, message } from "danger";

// Welcome message
message("👋 Thanks for your pull request!");

// Get PR details
const title = danger.github.pr.title;
const body = danger.github.pr.body || "";
const additions = danger.github.pr.additions;
const deletions = danger.github.pr.deletions;
const changedFiles = danger.git.modified_files.length + danger.git.created_files.length;

// Rule 1: Check title format
if (!title.includes("feat:") && !title.includes("fix:") && !title.includes("test:") && 
    !title.includes("chore:") && !title.includes("docs:") && !title.includes("refactor:")) {
  warn("⚠️ PR title should start with: feat:, fix:, test:, or chore:");
  message("Example: `feat: add new calculator button`");
}

// Rule 2: Check description
if (!body || body.length < 10) {
  warn("⚠️ Please add a meaningful PR description (at least 10 characters)");
}

// Rule 3: Check PR size
const totalChanges = additions + deletions;
if (totalChanges > 500) {
  warn("⚠️ Large PR (#{totalChanges} lines). Consider breaking into smaller PRs");
}

// Rule 4: Check for tests
const kotlinFiles = danger.git.modified_files.filter(f => f.endsWith('.kt') && !f.includes('test'));
const testFiles = danger.git.modified_files.filter(f => f.includes('test') || f.includes('Test'));

if (kotlinFiles.length > 0 && testFiles.length === 0) {
  message("💡 Consider adding tests for your Kotlin changes");
}

// Check for changelog
const hasChangelog = danger.git.modified_files.some(f => f.includes('CHANGELOG'));
const isTrivial = title.toLowerCase().includes('chore') || title.toLowerCase().includes('docs');

if (additions + deletions > 10 && !hasChangelog && !isTrivial) {
  message("📝 Consider updating CHANGELOG.md");
}

// Summary message
message(`📊 **PR Summary:**`);
message(`- Files changed: ${changedFiles}`);
message(`- Lines added: ${additions} ➕`);
message(`- Lines deleted: ${deletions} ➖`);
message(`- Total changes: ${totalChanges}`);

message("✅ Review complete!");
