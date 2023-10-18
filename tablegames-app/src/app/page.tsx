import Link from 'next/link'

export default function Home() {
  return (
    <ul className="flex mt-1 min-h-screen flex-row justify-start gap-3 p-3">
      <li><Link className="hover:underline" href="#">Отчёты</Link></li>
      <li><Link className="hover:underline" href="#">Техподдержка</Link></li>
      <li><Link className="hover:underline" href="#">Команды</Link></li>
    </ul>
  )
}
