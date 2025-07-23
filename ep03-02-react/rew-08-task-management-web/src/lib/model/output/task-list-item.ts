export type TaskListItem = {
  id: number;
  projectId: number;
  project: string;
  name: string;
  assignee: string;
  duedate?: string;
  startDate?: string;
  endDate?: string;
};
