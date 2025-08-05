import type { LucideProps } from "lucide-react"

export type MenuItem = {
  title: string
  icon?: React.ForwardRefExoticComponent<Omit<LucideProps, "ref"> & React.RefAttributes<SVGSVGElement>>
  url: string
}

export type MenuGroup = {
  label: string
  items: MenuItem []
}
