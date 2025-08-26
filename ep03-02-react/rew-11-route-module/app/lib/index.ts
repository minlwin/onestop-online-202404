import type { LucideProps } from "lucide-react";

export type IconType = React.ForwardRefExoticComponent<Omit<LucideProps, "ref"> & React.RefAttributes<SVGSVGElement>>